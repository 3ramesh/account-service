package com.vanilla.account.mapper;

import com.vanilla.account.dto.request.AccountRequestDto;
import com.vanilla.account.dto.response.AccountResponseDto;
import com.vanilla.account.entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    Account toEntity(AccountRequestDto dto);

    AccountResponseDto toResponseDto(Account entity);
}
