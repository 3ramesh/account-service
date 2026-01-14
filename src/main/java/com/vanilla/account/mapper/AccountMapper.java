package com.vanilla.account.mapper;

import com.vanilla.account.dto.request.AccountRequestDto;
import com.vanilla.account.dto.response.AccountResponseDto;
import com.vanilla.account.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    // Convert DTO → Entity
    Account toEntity(AccountRequestDto dto);

    // Convert Entity → DTO
    AccountResponseDto toDto(Account entity);
}
