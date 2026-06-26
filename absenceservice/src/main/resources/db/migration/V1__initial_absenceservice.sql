-- ===========================
-- TABLE: ABSENCES
-- ===========================
CREATE TABLE ABSENCES (
                          id INTEGER PRIMARY KEY AUTOINCREMENT,
                          employee_id INTEGER NOT NULL,
                          start_date DATE NOT NULL,
                          end_date DATE NOT NULL,
                          type TEXT NOT NULL,
                          reason TEXT,
                          status TEXT NOT NULL,
                          created_at DATE
);

-- ===========================
-- TABLE: ABSENCE_NOTIFICATIONS
-- ===========================
CREATE TABLE ABSENCE_NOTIFICATIONS (
                                       id INTEGER PRIMARY KEY AUTOINCREMENT,
                                       absence_id INTEGER NOT NULL,
                                       employee_id INTEGER NOT NULL,
                                       message TEXT NOT NULL,
                                       sent_date DATETIME,
                                       read BOOLEAN DEFAULT 0,

                                       FOREIGN KEY (absence_id)
                                           REFERENCES ABSENCES(id)
                                           ON DELETE NO ACTION
                                           ON UPDATE NO ACTION
);