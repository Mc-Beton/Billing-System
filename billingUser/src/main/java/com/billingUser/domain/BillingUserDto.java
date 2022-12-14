package com.billingUser.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillingUserDto {

    private Long id;
    private String name;
    private String surname;
    private String email;
}
