package com.anterka.springbatch.processor;

import com.anterka.springbatch.entity.PayrollRecord;
import com.anterka.springbatch.model.EmployeeTimesheet;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.springframework.batch.infrastructure.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class PayrollItemProcessor implements ItemProcessor<EmployeeTimesheet, PayrollRecord> {

    private static final double TAX_RATE_LOW = 0.10;      // 10% for gross < 3000
    private static final double TAX_RATE_MEDIUM = 0.15;   // 15% for gross 3000-5000
    private static final double TAX_RATE_HIGH = 0.20;     // 20% for gross > 5000

    @Override
    public @Nullable PayrollRecord process(EmployeeTimesheet timesheet) throws Exception {
        log.info("Processing payroll for employee: {} - {}",
                timesheet.employeeId(), timesheet.employeeName());

        // Validate input
        if (timesheet.hoursWorked() < 0 || timesheet.hourlyRate() <= 0) {
            log.warn("Invalid data for employee {}: hours={}, rate={}",
                    timesheet.employeeId(),
                    timesheet.hoursWorked(),
                    timesheet.hourlyRate());
            return null; // Skip this record
        }

        // Calculate gross salary
        double grossSalary = timesheet.hoursWorked() * timesheet.hourlyRate();

        // Calculate overtime (hours > 160 get 1.5x rate)
        if (timesheet.hoursWorked() > 160) {
            int overtimeHours = timesheet.hoursWorked() - 160;
            double overtimePay = overtimeHours * timesheet.hourlyRate() * 0.5;
            grossSalary += overtimePay;
            log.info("Overtime calculated for {}: {} hours, additional ${}",
                    timesheet.employeeName(), overtimeHours, overtimePay);
        }

        // Calculate tax based on progressive tax brackets
        double taxDeduction = calculateTax(grossSalary);
        double netSalary = grossSalary - taxDeduction;

        // Create payroll record
        PayrollRecord payrollRecord = new PayrollRecord();
        payrollRecord.setEmployeeId(timesheet.employeeId());
        payrollRecord.setEmployeeName(timesheet.employeeName());
        payrollRecord.setDepartment(timesheet.department());
        payrollRecord.setHoursWorked(timesheet.hoursWorked());
        payrollRecord.setHourlyRate(timesheet.hourlyRate());
        payrollRecord.setGrossSalary(grossSalary);
        payrollRecord.setTaxDeduction(taxDeduction);
        payrollRecord.setNetSalary(netSalary);
        payrollRecord.setPayrollMonth(timesheet.payrollMonth());
        payrollRecord.setFiscalYear(timesheet.fiscalYear());
        payrollRecord.setProcessedAt(LocalDateTime.now());

        log.info("Processed: {} - Gross: ${}, Tax: ${}, Net: ${}",
                timesheet.employeeName(),
                String.format("%.2f", grossSalary),
                String.format("%.2f", taxDeduction),
                String.format("%.2f", netSalary));

        return payrollRecord;
    }

    private double calculateTax(double grossSalary) {
        if (grossSalary < 3000) {
            return grossSalary * TAX_RATE_LOW;
        } else if (grossSalary <= 5000) {
            return grossSalary * TAX_RATE_MEDIUM;
        } else {
            return grossSalary * TAX_RATE_HIGH;
        }
    }
}
