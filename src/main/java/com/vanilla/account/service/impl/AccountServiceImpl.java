package com.vanilla.account.service.impl;

import com.vanilla.account.dto.request.AccountRequestDto;
import com.vanilla.account.dto.request.TransferRequestDto;
import com.vanilla.account.dto.response.AccountResponseDto;
import com.vanilla.account.dto.response.TransferResponseDto;
import com.vanilla.account.entity.Account;
import com.vanilla.account.exception.AccountNotFoundException;
import com.vanilla.account.exception.InsufficientBalanceException;
import com.vanilla.account.mapper.AccountMapper;
import com.vanilla.account.repository.AccountRepository;
import com.vanilla.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    @Transactional
    public AccountResponseDto createAccount(AccountRequestDto requestDto) {
        log.info("Creating account for owner: {}", requestDto.ownerName());
        Account account = accountMapper.toEntity(requestDto);
        accountRepository.save(account);
        log.info("Account created with accountNumber: {}", account.getAccountNumber());
        return accountMapper.toResponseDto(account);
    }

    @Transactional(readOnly = true)
    public AccountResponseDto getAccountByNumber(String accountNumber) {
        log.info("Fetching account details for accountNumber: {}", accountNumber);

        Account account = findByAccountNumber(accountNumber);

        log.info("Account found: {}", account.getAccountNumber());
        return accountMapper.toResponseDto(account);
    }

    @Transactional
    @Override
    public TransferResponseDto transfer(TransferRequestDto request) {
        log.info("Transfer requested from {} to {} amount {}", request.fromAccount(), request.toAccount(), request.amount());
        try {
            Account sender = findByAccountNumber(request.fromAccount());
            Account receiver = findByAccountNumber(request.toAccount());

            validateBalance(sender, request.amount());

            debitAccount(sender, request.amount());
            creditAccount(receiver, request.amount());
            accountRepository.saveAll(List.of(sender, receiver));

            log.info("Transfer successful from {} to {} amount {}",
                    sender.getAccountNumber(), receiver.getAccountNumber(), request.amount());
            return TransferResponseDto.success(request.fromAccount(), request.toAccount(), request.amount());

        } catch (AccountNotFoundException ex) {
            log.error("Transfer failed: {}", ex.getMessage());
            return TransferResponseDto.failure(request.fromAccount(), request.toAccount(), request.amount(), ex.getMessage());
        } catch (Exception ex) {
            log.error("Unexpected error during transfer: {}", ex.getMessage(), ex);
            return TransferResponseDto.failure(request.fromAccount(), request.toAccount(), request.amount(),
                    "Unexpected error occurred: " + ex.getMessage());
        }
    }

    private void validateBalance(Account sender, BigDecimal amount) {
        if (sender.getBalance().compareTo(amount) < 0) {
            throw new InsufficientBalanceException("Insufficient balance in account: " + sender.getAccountNumber());
        }
    }

    private void creditAccount(Account account, BigDecimal amount) {
        account.setBalance(account.getBalance().add(amount));
        log.info("Credited {} to account {}", amount, account.getAccountNumber());
    }

    private void debitAccount(Account account, BigDecimal amount) {
        account.setBalance(account.getBalance().subtract(amount));
        log.info("Debited {} from account {}", amount, account.getAccountNumber());
    }

    private Account findByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> {
                    log.error("Account not found: {}", accountNumber);
                    return new AccountNotFoundException("Account not found: " + accountNumber);
                });
    }

}
