package com.vanilla.account.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record TransferRequestDto(

        @NotBlank(message = "From account must not be blank")
        String fromAccount,

        @NotBlank(message = "To account must not be blank")
        String toAccount,

        @NotNull(message = "Transfer amount must not be null")
        @Positive(message = "Transfer amount must be greater than zero")
        BigDecimal amount

) {
}
