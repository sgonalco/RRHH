-- ===========================
-- TABLE: LEAVE_REQUESTS
-- ===========================
CREATE TABLE LEAVE_REQUESTS (
                                id INTEGER PRIMARY KEY AUTOINCREMENT,
                                employee_id INTEGER NOT NULL,
                                start_date DATE NOT NULL,
                                end_date DATE NOT NULL,
                                days_requested INTEGER NOT NULL,
                                reason TEXT,
                                status TEXT NOT NULL,
                                created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- ===========================
-- TABLE: LEAVE_BALANCE
-- ===========================
CREATE TABLE LEAVE_BALANCE (
                               employee_id INTEGER PRIMARY KEY,
                               total_days INTEGER NOT NULL,
                               used_days INTEGER NOT NULL DEFAULT 0,
                               remaining_days INTEGER NOT NULL,
                               updated_at DATETIME
);

-- ===========================
-- TABLE: LEAVE_NOTIFICATIONS
-- ===========================
CREATE TABLE LEAVE_NOTIFICATIONS (
                                     id INTEGER PRIMARY KEY AUTOINCREMENT,
                                     leave_request_id INTEGER NOT NULL,
                                     employee_id INTEGER NOT NULL,
                                     message TEXT NOT NULL,
                                     sent_date DATETIME,
                                     read BOOLEAN NOT NULL DEFAULT 0,

                                     FOREIGN KEY (leave_request_id)
                                         REFERENCES LEAVE_REQUESTS(id)
                                         ON DELETE NO ACTION
                                         ON UPDATE NO ACTION
);