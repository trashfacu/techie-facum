package com.techie.controller;

import com.techie.model.UserModel;
import com.techie.services.ProcessorService;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
class UserDataController {

    private final ProcessorService processorService;
    private final JobLauncher jobLauncher;

    private final Job importUserJob;

    @PostMapping("/process")
    public List<UserModel> processUserData(@RequestBody String csvData) {
        List<String> lines = parseCSV(csvData);
        return processorService.processUsers(lines);
    }


    @PostMapping("/process-batch")
    public String processUserDataBatch() throws Exception {
        long startTime = System.currentTimeMillis();
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();
        jobLauncher.run(importUserJob, jobParameters);
        long endTime = System.currentTimeMillis();
        return String.format("Batch job completed in %d ms", (endTime - startTime));
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