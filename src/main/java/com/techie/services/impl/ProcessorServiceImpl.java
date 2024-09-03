package com.techie.services.impl;

import com.techie.model.UserModel;
import com.techie.services.ProcessorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProcessorServiceImpl implements ProcessorService {

    @Override
    public List<UserModel> processUsers(List<String> lines) {
        List<UserModel> users = new ArrayList<>();
        for (String line : lines) {

            // TODO: Implement the following business rules
            // 1. Parsear la línea CSV en el objeto UserModel
            // 2. Si el nombre del usuario empieza por 'A', escribe su nombre en mayúsculas
            // 3. Si el email del usuario no contiene '@', añade «@default.com».
            // 4. Si el usuario es menor de 18 años, establece su edad en 18 años
        }
        return users;
    }
}
