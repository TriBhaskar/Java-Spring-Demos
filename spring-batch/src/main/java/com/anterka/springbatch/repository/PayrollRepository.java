package com.anterka.springbatch.repository;

import com.anterka.springbatch.entity.PayrollRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayrollRepository extends JpaRepository<PayrollRecord, Long> {

    List<PayrollRecord> findByPayrollMonthAndFiscalYear(String payrollMonth, Integer fiscalYear);

    @Query("SELECT SUM(p.netSalary) FROM PayrollRecord p WHERE p.payrollMonth = :payrollMonth AND p.fiscalYear = :fiscalYear")
    Double getTotalPayrollByMonthAndYear(String payrollMonth, Integer fiscalYear);

    List<PayrollRecord> findByDepartment(String department);
}
