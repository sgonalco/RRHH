-- ===========================
-- TABLE: EMPLOYEES
-- ===========================
CREATE TABLE EMPLOYEES (
                           id INTEGER PRIMARY KEY AUTOINCREMENT,
                           first_name TEXT NOT NULL,
                           last_name TEXT NOT NULL,
                           dni INTEGER NOT NULL UNIQUE,
                           birthdate DATE,
                           phone INTEGER,
                           email TEXT NOT NULL UNIQUE,
                           address TEXT,
                           hire_date DATE,
                           salary INTEGER NOT NULL,
                           department_id INTEGER,
                           position TEXT,
                           status TEXT NOT NULL,
                           remaining_vacation_days INTEGER DEFAULT 30
);

-- ===========================
-- TABLE: SALARY_HISTORY
-- ===========================
CREATE TABLE SALARY_HISTORY (
                                id INTEGER PRIMARY KEY AUTOINCREMENT,
                                employee_id INTEGER NOT NULL,
                                old_salary INTEGER NOT NULL,
                                new_salary INTEGER NOT NULL,
                                change_date DATE NOT NULL,
                                reason TEXT,

                                FOREIGN KEY (employee_id)
                                    REFERENCES EMPLOYEES(id)
                                    ON DELETE NO ACTION
                                    ON UPDATE NO ACTION
);

-- ===========================
-- TABLE: BENEFITS
-- ===========================
CREATE TABLE BENEFITS (
                          id INTEGER PRIMARY KEY AUTOINCREMENT,
                          name TEXT NOT NULL,
                          description TEXT,
                          amount INTEGER NOT NULL
);

-- ===========================
-- TABLE: EMPLOYEE_HAS_BENEFITS
-- ===========================
CREATE TABLE EMPLOYEE_HAS_BENEFITS (
                                       employee_id INTEGER NOT NULL,
                                       benefit_id INTEGER NOT NULL,

                                       PRIMARY KEY (employee_id, benefit_id),

                                       FOREIGN KEY (employee_id)
                                           REFERENCES EMPLOYEES(id)
                                           ON DELETE NO ACTION
                                           ON UPDATE NO ACTION,

                                       FOREIGN KEY (benefit_id)
                                           REFERENCES BENEFITS(id)
                                           ON DELETE NO ACTION
                                           ON UPDATE NO ACTION
);

-- ===========================
-- TABLE: DEDUCTIONS
-- ===========================
CREATE TABLE DEDUCTIONS (
                            id INTEGER PRIMARY KEY AUTOINCREMENT,
                            name TEXT NOT NULL,
                            description TEXT,
                            amount INTEGER NOT NULL
);

-- ===========================
-- TABLE: EMPLOYEE_HAS_DEDUCTIONS
-- ===========================
CREATE TABLE EMPLOYEE_HAS_DEDUCTIONS (
                                         employee_id INTEGER NOT NULL,
                                         deduction_id INTEGER NOT NULL,

                                         PRIMARY KEY (employee_id, deduction_id),

                                         FOREIGN KEY (employee_id)
                                             REFERENCES EMPLOYEES(id)
                                             ON DELETE NO ACTION
                                             ON UPDATE NO ACTION,

                                         FOREIGN KEY (deduction_id)
                                             REFERENCES DEDUCTIONS(id)
                                             ON DELETE NO ACTION
                                             ON UPDATE NO ACTION
);