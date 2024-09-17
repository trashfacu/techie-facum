package com.techie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USERS")
public class UserModel {
    private String name;
    private String email;
    private Integer age;
    private BigDecimal netWorth;

}