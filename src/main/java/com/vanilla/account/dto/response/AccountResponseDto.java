package com.vanilla.account.dto.response;

import com.vanilla.account.dto.common.ModelBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountResponseDto extends ModelBase {

    private String id;
    private String accountNumber;
    private String ownerName;
    private BigDecimal balance;
}