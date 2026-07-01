package com.example.rrhh.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "ABSENCE_NOTIFICATION",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"absence_id", "notification_id"})
        }
)
public class AbsenceNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "absence_id", nullable = false)
    private Absence absence;

    @ManyToOne
    @JoinColumn(name = "notification_id", nullable = false)
    private Notification notification;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Absence getAbsence() {
        return absence;
    }

    public void setAbsence(Absence absence) {
        this.absence = absence;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }
}