package com.techie.services;

import com.techie.model.UserModel;

import java.util.List;

public interface ProcessorService {
    List<UserModel> processUsers(List<String> lines);
}
