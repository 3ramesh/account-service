package com.vanilla.account.service.impl;

import com.vanilla.account.dto.request.AccountRequestDto;
import com.vanilla.account.dto.response.AccountResponseDto;
import com.vanilla.account.entity.Account;
import com.vanilla.account.mapper.AccountMapper;
import com.vanilla.account.repository.AccountRepository;
import com.vanilla.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    @Transactional
    public AccountResponseDto createAccount(AccountRequestDto requestDto) {
        log.info("Creating account for owner: {}", requestDto.getOwnerName());
        Account account = accountMapper.toEntity(requestDto);
        accountRepository.save(account);
        log.info("Account created with accountNumber: {}", account.getAccountNumber());
        return accountMapper.toDto(account);
    }
}
