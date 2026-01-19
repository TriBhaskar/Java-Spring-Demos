package com.anterka.springbatch.config;

import com.anterka.springbatch.entity.PayrollRecord;
import com.anterka.springbatch.model.EmployeeTimesheet;
import com.anterka.springbatch.processor.PayrollItemProcessor;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.job.parameters.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.infrastructure.item.database.JpaItemWriter;
import org.springframework.batch.infrastructure.item.database.builder.JpaItemWriterBuilder;
import org.springframework.batch.infrastructure.item.file.FlatFileItemReader;
import org.springframework.batch.infrastructure.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class BatchConfiguration {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;
    private final EntityManagerFactory entityManagerFactory;
    private final PayrollItemProcessor payrollItemProcessor;

    @Value("${batch.input.file}")
    private Resource inputResource;

    /**
     * ItemReader: Reads employee timesheet data from CSV file
     */
    @Bean
    public FlatFileItemReader<EmployeeTimesheet> timesheetReader() {
        return new FlatFileItemReaderBuilder<EmployeeTimesheet>()
                .name("timesheetReader")
                .resource(inputResource)
                .linesToSkip(1) // Skip header row
                .delimited()
                .names("employeeId", "employeeName", "department",
                        "hoursWorked", "hourlyRate", "payrollMonth", "fiscalYear")
                .targetType(EmployeeTimesheet.class)
                .build();
    }

    /**
     * ItemWriter: Writes processed payroll records to database using JPA
     */
    @Bean
    public JpaItemWriter<PayrollRecord> payrollWriter() {
        return new JpaItemWriterBuilder<PayrollRecord>()
                .entityManagerFactory(entityManagerFactory)
                .build();
    }

    /**
     * Step: Process employee timesheets in chunks of 10
     */
    @Bean
    public Step processPayrollStep() {
        return new StepBuilder("processPayrollStep", jobRepository)
                .<EmployeeTimesheet, PayrollRecord>chunk(10, transactionManager)
                .reader(timesheetReader())
                .processor(payrollItemProcessor)
                .writer(payrollWriter())
                .faultTolerant()
                .skip(Exception.class)
                .skipLimit(5) // Skip up to 5 problematic records
                .build();
    }

    /**
     * Job: Complete payroll processing job
     */
    @Bean
    public Job payrollProcessingJob(JobCompletionNotificationListener listener) {
        return new JobBuilder("payrollProcessingJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .start(processPayrollStep())
                .build();
    }
}
