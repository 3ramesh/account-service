package com.vanilla.account.service;

import com.vanilla.account.dto.request.AccountRequestDto;
import com.vanilla.account.dto.request.TransferRequestDto;
import com.vanilla.account.dto.response.AccountResponseDto;
import com.vanilla.account.dto.response.TransferResponseDto;

public interface AccountService {

    AccountResponseDto createAccount(AccountRequestDto requestDto);

    AccountResponseDto getAccountByNumber(String accountNumber);

    TransferResponseDto transfer(TransferRequestDto request);


}
