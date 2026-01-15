package com.vanilla.account.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record AccountRequestDto(

        @NotBlank(message = "Account number must not be blank") String accountNumber,

        @NotBlank(message = "Owner name must not be blank") String ownerName,

        @NotNull(message = "Balance must not be null") @PositiveOrZero(message = "Balance must be zero or positive") BigDecimal balance

) {
}