package com.vanilla.account.controller;

import com.vanilla.account.dto.request.AccountRequestDto;
import com.vanilla.account.dto.request.TransferRequestDto;
import com.vanilla.account.dto.response.AccountResponseDto;
import com.vanilla.account.dto.response.TransferResponseDto;
import com.vanilla.account.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.vanilla.account.constants.ApiConstant.*;

@RestController
@RequestMapping(API_V1 + ACCOUNTS)
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountResponseDto> createAccount(@Valid @RequestBody AccountRequestDto request) {
        return ResponseEntity.ok(accountService.createAccount(request));
    }

    @GetMapping(WRAP_ACCOUNT_NUMBER)
    public ResponseEntity<AccountResponseDto> getAccount(@PathVariable String accountNumber) {
        return ResponseEntity.ok(accountService.getAccountByNumber(accountNumber));
    }


    @PostMapping(TRANSFER)
    public ResponseEntity<TransferResponseDto> transfer(@Valid @RequestBody TransferRequestDto request) {
        return ResponseEntity.ok(accountService.transfer(request));
    }
}
