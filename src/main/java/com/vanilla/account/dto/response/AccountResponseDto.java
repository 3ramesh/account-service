package com.vanilla.account.dto.response;

import java.math.BigDecimal;

public record AccountResponseDto(

        String id,
        String accountNumber,
        String ownerName,
        BigDecimal balance

) {
}