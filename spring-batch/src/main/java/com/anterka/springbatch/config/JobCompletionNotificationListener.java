package com.anterka.springbatch.config;

import com.anterka.springbatch.entity.PayrollRecord;
import com.anterka.springbatch.repository.PayrollRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.job.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class JobCompletionNotificationListener implements JobExecutionListener {

    private final PayrollRepository payrollRepository;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("====================================");
        log.info("Starting Payroll Processing Job");
        log.info("Job Name: {}", jobExecution.getJobInstance().getJobName());
        log.info("Job Parameters: {}", jobExecution.getJobParameters());
        log.info("====================================");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("====================================");
            log.info("JOB COMPLETED SUCCESSFULLY!");
            log.info("====================================");

            // Generate summary report
            List<PayrollRecord> records = payrollRepository.findAll();

            log.info("Total Records Processed: {}", records.size());

            // Calculate totals
            double totalGross = records.stream()
                    .mapToDouble(PayrollRecord::getGrossSalary)
                    .sum();

            double totalTax = records.stream()
                    .mapToDouble(PayrollRecord::getTaxDeduction)
                    .sum();

            double totalNet = records.stream()
                    .mapToDouble(PayrollRecord::getNetSalary)
                    .sum();

            log.info("====================================");
            log.info("PAYROLL SUMMARY");
            log.info("====================================");
            log.info("Total Gross Salary: ${}", String.format("%.2f", totalGross));
            log.info("Total Tax Deducted: ${}", String.format("%.2f", totalTax));
            log.info("Total Net Payable: ${}", String.format("%.2f", totalNet));
            log.info("====================================");

            // Department-wise summary
            log.info("Department-wise Breakdown:");
            records.stream()
                    .map(PayrollRecord::getDepartment)
                    .distinct()
                    .forEach(dept -> {
                        List<PayrollRecord> deptRecords = payrollRepository.findByDepartment(dept);
                        double deptTotal = deptRecords.stream()
                                .mapToDouble(PayrollRecord::getNetSalary)
                                .sum();
                        log.info("  {} - {} employees, Total: ${}",
                                dept,
                                deptRecords.size(),
                                String.format("%.2f", deptTotal));
                    });

            log.info("====================================");

        } else if (jobExecution.getStatus() == BatchStatus.FAILED) {
            log.error("====================================");
            log.error("JOB FAILED!");
            log.error("Failure Exceptions:");
            jobExecution.getAllFailureExceptions().forEach(throwable ->
                    log.error("  - {}", throwable.getMessage())
            );
            log.error("====================================");
        }
    }
}
