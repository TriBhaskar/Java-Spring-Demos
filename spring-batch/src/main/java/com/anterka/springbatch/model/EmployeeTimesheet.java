package com.anterka.springbatch.model;

public record EmployeeTimesheet(
        Long employeeId,
        String employeeName,
        String department,
        Integer hoursWorked,
        Double hourlyRate,
        String payrollMonth,
        Integer fiscalYear
) {
}
