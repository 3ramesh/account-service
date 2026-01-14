package com.vanilla.account.service;

import com.vanilla.account.dto.request.AccountRequestDto;
import com.vanilla.account.dto.response.AccountResponseDto;

public interface AccountService {

    AccountResponseDto createAccount(AccountRequestDto requestDto);

    AccountResponseDto getAccountByNumber(String accountNumber);

}
