package com.example.rrhh.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity
@Table(name = "SALARY")
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "old_salary", nullable = false)
    private Integer oldSalary;

    @Column(name = "new_salary", nullable = false)
    private Integer newSalary;

    @Column(name = "change_date")
    private LocalDate changeDate;

    @NotBlank(message = "reaosn cannot be empty")
    @Column(name = "reason")
    private String reason;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    public Salary() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDate getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(LocalDate changeDate) {
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