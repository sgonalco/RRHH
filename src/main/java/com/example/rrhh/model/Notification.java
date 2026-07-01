package com.example.rrhh.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "NOTIFICATION")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank(message = "message cannot be empty")
    @Column(name = "message")
    private String message;

    @Column(name = "sent_date")
    private LocalDateTime sentDate;

    @Column(name = "read")
    private Boolean read;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToMany(mappedBy = "notification")
    private Set<AbsenceNotification> absenceNotifications = new HashSet<>();

    @OneToMany(mappedBy = "notification")
    private Set<LeaveNotification> leaveNotifications = new HashSet<>();

    public Notification() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getSentDate() {
        return sentDate;
    }

    public void setSentDate(LocalDateTime sentDate) {
        this.sentDate = sentDate;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<AbsenceNotification> getAbsenceNotifications() {
        return absenceNotifications;
    }

    public void setAbsenceNotifications(Set<AbsenceNotification> absenceNotifications) {
        this.absenceNotifications = absenceNotifications;
    }

    public Set<LeaveNotification> getLeaveNotifications() {
        return leaveNotifications;
    }

    public void setLeaveNotifications(Set<LeaveNotification> leaveNotifications) {
        this.leaveNotifications = leaveNotifications;
    }
}