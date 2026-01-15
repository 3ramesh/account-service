package com.vanilla.account.dto.response;

import java.time.Instant;
import java.util.Map;

public record ValidationErrorResponse(
        int status,
        String error,
        String message,
        Map<String, String> errors,
        String path,
        Instant timestamp
) {
}