package com.example.rrhh.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "SALARY")
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "employee_id", nullable = false)
    private Integer employeeId;

    @NotNull
    @Column(name = "old_salary", nullable = false)
    private Integer oldSalary;

    @NotNull
    @Column(name = "new_salary", nullable = false)
    private Integer newSalary;

    @NotBlank
    @Column(name = "change_date", nullable = false)
    private String changeDate;

    @NotBlank
    @Column(name = "reason", nullable = false)
    private String reason;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Salary() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getOldSalary() {
        return oldSalary;
    }

    public void setOldSalary(Integer oldSalary) {
        this.oldSalary = oldSalary;
    }

    public Integer getNewSalary() {
        return newSalary;
    }

    public void setNewSalary(Integer newSalary) {
        this.newSalary = newSalary;
    }

    public String getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(String changeDate) {
        this.changeDate = changeDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
