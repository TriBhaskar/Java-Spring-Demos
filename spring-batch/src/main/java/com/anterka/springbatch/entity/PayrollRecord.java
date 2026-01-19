package com.anterka.springbatch.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "payroll_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayrollRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long employeeId;

    @Column(nullable = false)
    private String employeeName;

    private String department;

    @Column(nullable = false)
    private Integer hoursWorked;

    @Column(nullable = false)
    private Double hourlyRate;

    @Column(nullable = false)
    private Double grossSalary;

    @Column(nullable = false)
    private Double taxDeduction;

    @Column(nullable = false)
    private Double netSalary;

    private String payrollMonth;

    private Integer fiscalYear;

    @Column(nullable = false)
    private LocalDateTime processedAt;
}
