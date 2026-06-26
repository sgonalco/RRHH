-- ===========================
-- TABLE: PAYROLL
-- ===========================
CREATE TABLE PAYROLL (
                         id INTEGER PRIMARY KEY AUTOINCREMENT,
                         employee_id INTEGER NOT NULL,
                         month TEXT NOT NULL,
                         year TEXT NOT NULL,
                         base_salary INTEGER NOT NULL,
                         gross_salary INTEGER NOT NULL,
                         net_salary INTEGER NOT NULL,
                         payment_date DATE,
                         status TEXT NOT NULL
);

-- ===========================
-- TABLE: PAYROLL_DETAILS
-- ===========================
CREATE TABLE PAYROLL_DETAILS (
                                 id INTEGER PRIMARY KEY AUTOINCREMENT,
                                 payroll_id INTEGER NOT NULL,
                                 concept TEXT NOT NULL,
                                 amount INTEGER NOT NULL,
                                 type TEXT NOT NULL,

                                 FOREIGN KEY (payroll_id)
                                     REFERENCES PAYROLL(id)
                                     ON DELETE NO ACTION
                                     ON UPDATE NO ACTION
);

-- ===========================
-- TABLE: PAYROLL_REPORTS
-- ===========================
CREATE TABLE PAYROLL_REPORTS (
                                 id INTEGER PRIMARY KEY AUTOINCREMENT,
                                 payroll_detail_id INTEGER NOT NULL,
                                 month TEXT NOT NULL,
                                 year TEXT NOT NULL,

                                 FOREIGN KEY (payroll_detail_id)
                                     REFERENCES PAYROLL_DETAILS(id)
                                     ON DELETE NO ACTION
                                     ON UPDATE NO ACTION
);