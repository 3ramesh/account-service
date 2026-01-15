package com.vanilla.account.dto.response;

import java.math.BigDecimal;

import static com.vanilla.account.constants.enums.TransferStatus.FAILED;
import static com.vanilla.account.constants.enums.TransferStatus.SUCCESS;

public record TransferResponseDto(
        String fromAccount,
        String toAccount,
        BigDecimal amount,
        String status,
        String message
) {
    public static TransferResponseDto success(String fromAccount, String toAccount, BigDecimal amount) {
        return new TransferResponseDto(fromAccount, toAccount, amount, SUCCESS.name(), "Transfer completed successfully");
    }

    public static TransferResponseDto failure(String fromAccount, String toAccount, BigDecimal amount, String message) {
        return new TransferResponseDto(fromAccount, toAccount, amount, FAILED.name(), message);
    }
}
