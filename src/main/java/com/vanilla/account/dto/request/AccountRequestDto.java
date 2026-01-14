package com.vanilla.account.dto.request;

import com.vanilla.account.dto.common.ModelBase;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountRequestDto extends ModelBase {

    @NotBlank
    private String accountNumber;

    @NotBlank
    private String ownerName;

    @NotNull
    @PositiveOrZero
    private BigDecimal balance;
}