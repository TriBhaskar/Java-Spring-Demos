package com.anterka.springbatch.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.JobExecution;
import org.springframework.batch.core.job.parameters.InvalidJobParametersException;
import org.springframework.batch.core.job.parameters.JobParameters;
import org.springframework.batch.core.job.parameters.JobParametersBuilder;
import org.springframework.batch.core.launch.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/batch")
@RequiredArgsConstructor
public class BatchController {

    private final JobLauncher jobLauncher;
    private final Job payrollProcessingJob;

    @PostMapping("/process-payroll")
    public ResponseEntity<Map<String, Object>> processPayroll(
            @RequestParam(required = false, defaultValue = "December") String month,
            @RequestParam(required = false, defaultValue = "2024") Integer year) {

        Map<String, Object> response = new HashMap<>();

        try {
            // Create job parameters
            JobParameters jobParameters = new JobParametersBuilder()
                    .addString("month", month)
                    .addLong("year", year.longValue())
                    .addLong("startTime", System.currentTimeMillis())
                    .toJobParameters();

            // Launch the job
            log.info("Launching payroll processing job for {} {}", month, year);
            JobExecution execution = jobLauncher.run(payrollProcessingJob, jobParameters);

            // Prepare response
            response.put("status", "SUCCESS");
            response.put("message", "Payroll processing job started successfully");
            response.put("jobExecutionId", execution.getId());
            response.put("jobStatus", execution.getStatus().toString());
            response.put("startTime", execution.getStartTime());

            return ResponseEntity.ok(response);

        } catch (JobExecutionAlreadyRunningException e) {
            response.put("status", "ERROR");
            response.put("message", "Job is already running");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);

        } catch (JobRestartException e) {
            response.put("status", "ERROR");
            response.put("message", "Job restart failed: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);

        } catch (JobInstanceAlreadyCompleteException e) {
            response.put("status", "ERROR");
            response.put("message", "Job already completed for these parameters");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        } catch (InvalidJobParametersException e) {
            response.put("status", "ERROR");
            response.put("message", "Invalid job parameters: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @GetMapping("/status")
    public ResponseEntity<Map<String, String>> getStatus() {
        Map<String, String> status = new HashMap<>();
        status.put("service", "Payroll Batch Processing");
        status.put("status", "RUNNING");
        return ResponseEntity.ok(status);
    }
}
