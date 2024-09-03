package com.techie.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
public class UserModel {

    private String name;
    private String email;
    private int age;
    private BigDecimal netWorth;
}