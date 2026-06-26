-- ===========================
-- TABLE: DEPARTMENTS
-- ===========================
CREATE TABLE DEPARTMENTS (
                             id INTEGER PRIMARY KEY AUTOINCREMENT,
                             name TEXT NOT NULL UNIQUE,
                             description TEXT,
                             manager_id INTEGER,
                             created_at DATETIME,
                             updated_at DATETIME
);

-- ===========================
-- TABLE: DEPARTMENT_GOALS
-- ===========================
CREATE TABLE DEPARTMENT_GOALS (
                                  department_id INTEGER NOT NULL,
                                  title TEXT NOT NULL,
                                  description TEXT,
                                  status TEXT,
                                  start_date DATETIME,
                                  end_date DATETIME,

                                  PRIMARY KEY (department_id, title),

                                  FOREIGN KEY (department_id)
                                      REFERENCES DEPARTMENTS(id)
                                      ON DELETE NO ACTION
                                      ON UPDATE NO ACTION
);