package com.techie.controller;

import com.techie.model.UserModel;
import com.techie.services.ProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@RestController
class UserDataController {

    @Autowired
    private ProcessorService processorService;

    @PostMapping("/process")
    public List<UserModel> processUserData(@RequestBody String csvData) {
        List<String> lines = parseCSV(csvData);
        return processorService.processUsers(lines);
    }

    private List<String> parseCSV(String csvData) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new StringReader(csvData))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error parsing CSV data", e);
        }
        return lines;
    }
}