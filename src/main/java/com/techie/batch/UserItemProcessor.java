package com.techie.batch;

import com.techie.model.UserModel;
import org.springframework.batch.item.ItemProcessor;

import java.math.BigDecimal;

public class UserItemProcessor implements ItemProcessor<UserModel, UserModel> {

    @Override
    public UserModel process(final UserModel user) throws Exception {
        String name = user.getName();
        String email = user.getEmail();
        int age = user.getAge();
        BigDecimal netWorth = user.getNetWorth();

        if (name.startsWith("A")) {
            name = name.toUpperCase();
        }

        if (!email.contains("@")) {
            email += "@default.com";
        }
        age = Math.max(age, 18);

        if (netWorth.compareTo(new BigDecimal("1000000")) > 0) {
            name += " (Millionaire)";
        }

        return new UserModel(name, email, age, netWorth);
    }
}
