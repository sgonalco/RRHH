CREATE TABLE IF NOT EXISTS "USER" (
    "id" INTEGER NOT NULL,
    "username" VARCHAR,
    "password" VARCHAR,
    "email" VARCHAR,
    "created_at" DATE,
    "updated_at" DATE,
    PRIMARY KEY("id","username")
);

CREATE TABLE IF NOT EXISTS "ROLE" (
    "id" INTEGER NOT NULL,
    "name" VARCHAR,
    PRIMARY KEY("id")
);

CREATE TABLE IF NOT EXISTS "USER_ROLES" (
    "user_id" INTEGER NOT NULL,
    "role_id" INTEGER,
    PRIMARY KEY("user_id","role_id"),
    FOREIGN KEY ("user_id") REFERENCES "USER"("id")
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY ("role_id") REFERENCES "ROLE"("id")
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "DEPARTMENT" (
    "id" INTEGER NOT NULL,
    "name" VARCHAR,
    "description" TEXT,
    "manager_id" INTEGER,
    "created_at" DATE,
    "updated_at" DATE,
    PRIMARY KEY("id"),
    FOREIGN KEY ("id") REFERENCES "DEPARTMENT_GOALS"("department_id")
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "GOAL" (
    "id" INTEGER NOT NULL,
    "title" VARCHAR,
    "description" TEXT,
    "status" VARCHAR,
    "start_date" DATE,
    "end_date" DATE,
    PRIMARY KEY("id","title"),
    FOREIGN KEY ("id") REFERENCES "DEPARTMENT_GOALS"("goal_id")
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "DEPARTMENT_GOALS" (
    "department_id" INTEGER NOT NULL,
    "goal_id" INTEGER,
    PRIMARY KEY("department_id","goal_id")
);

CREATE TABLE IF NOT EXISTS "EMPLOYEE" (
    "id" INTEGER NOT NULL,
    "first_name" VARCHAR,
    "last_name" VARCHAR,
    "dni" VARCHAR,
    "birthdate" DATE,
    "phone_number" INTEGER,
    "email" VARCHAR,
    "address" VARCHAR,
    "hire_date" VARCHAR,
    "salary" INTEGER,
    "department_id" INTEGER,
    "position" VARCHAR,
    "status" VARCHAR,
    "user_id" INTEGER,
    PRIMARY KEY("id","dni"),
    FOREIGN KEY ("department_id") REFERENCES "DEPARTMENT"("id")
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY ("user_id") REFERENCES "USER"("id")
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY ("id") REFERENCES "REQUEST"("employee_id")
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY ("id") REFERENCES "BALANCE"("employee_id")
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "BENEFIT" (
    "id" INTEGER NOT NULL,
    "name" VARCHAR,
    "description" TEXT,
    "amount" INTEGER,
    PRIMARY KEY("id","name")
);

CREATE TABLE IF NOT EXISTS "DEDUCTION" (
    "id" INTEGER NOT NULL,
    "name" VARCHAR,
    "description" TEXT,
    "amount" INTEGER,
    PRIMARY KEY("id","name"),
    FOREIGN KEY ("id") REFERENCES "EMPLOYEE_DEDUCTIONS"("deduction_id")
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "SALARY" (
    "id" INTEGER NOT NULL,
    "employee_id" INTEGER,
    "old_salary" INTEGER,
    "new_salary" INTEGER,
    "change_date" DATE,
    "reason" TEXT,
    PRIMARY KEY("id","employee_id"),
    FOREIGN KEY ("employee_id") REFERENCES "EMPLOYEE"("id")
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "EMPLOYEE_BENEFITS" (
    "employee_id" INTEGER NOT NULL,
    "benefit_id" INTEGER,
    PRIMARY KEY("employee_id","benefit_id"),
    FOREIGN KEY ("employee_id") REFERENCES "EMPLOYEE"("id")
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY ("benefit_id") REFERENCES "BENEFIT"("id")
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "EMPLOYEE_DEDUCTIONS" (
    "employee_id" INTEGER NOT NULL,
    "deduction_id" INTEGER,
    PRIMARY KEY("employee_id","deduction_id"),
    FOREIGN KEY ("employee_id") REFERENCES "EMPLOYEE"("id")
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "PAYROLL" (
    "id" INTEGER NOT NULL,
    "employee_id" INTEGER,
    "month" VARCHAR,
    "year" VARCHAR,
    "base" INTEGER,
    "gross" INTEGER,
    "net" INTEGER,
    "payment_date" DATE,
    "status" VARCHAR,
    PRIMARY KEY("id"),
    FOREIGN KEY ("employee_id") REFERENCES "EMPLOYEE"("id")
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "RECEPIT" (
    "id" INTEGER NOT NULL,
    "payroll_id" INTEGER,
    "concept" VARCHAR,
    "amount" INTEGER,
    "type" VARCHAR,
    PRIMARY KEY("id"),
    FOREIGN KEY ("payroll_id") REFERENCES "PAYROLL"("id")
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "REPORT" (
    "id" INTEGER NOT NULL,
    "reciept_id" INTEGER,
    "month" VARCHAR,
    "year" VARCHAR,
    PRIMARY KEY("id"),
    FOREIGN KEY ("reciept_id") REFERENCES "RECEPIT"("id")
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "ABSENCE" (
    "id" INTEGER NOT NULL,
    "employee_id" INTEGER,
    "start_date" DATE,
    "end_date" DATE,
    "type" VARCHAR,
    "reason" TEXT,
    "status" VARCHAR,
    "created_at" DATE,
    PRIMARY KEY("id"),
    FOREIGN KEY ("employee_id") REFERENCES "EMPLOYEE"("id")
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "NOTIFICATION" (
    "id" INTEGER NOT NULL,
    "message" TEXT,
    "sent_date" DATE,
    "read" BOOLEAN,
    PRIMARY KEY("id"),
    FOREIGN KEY ("id") REFERENCES "ABSENCE_NOTIFICATION"("notification_id")
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "ABSENCE_NOTIFICATION" (
    "id" INTEGER NOT NULL,
    "absence_id" INTEGER,
    "notification_id" INTEGER,
    "employee_id" INTEGER,
    PRIMARY KEY("id"),
    FOREIGN KEY ("absence_id") REFERENCES "ABSENCE"("id")
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY ("employee_id") REFERENCES "EMPLOYEE"("id")
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "REQUEST" (
    "id" INTEGER NOT NULL,
    "employee_id" INTEGER,
    "days_requested" INTEGER,
    "start_date" DATE,
    "end_date" DATE,
    "reason" TEXT,
    "status" VARCHAR,
    "created_at" DATE,
    PRIMARY KEY("id")
);

CREATE TABLE IF NOT EXISTS "LEAVE_NOTIFICATION" (
    "id" INTEGER NOT NULL,
    "request_id" INTEGER,
    "notification_id" INTEGER,
    "employee_id" INTEGER,
    PRIMARY KEY("id"),
    FOREIGN KEY ("request_id") REFERENCES "REQUEST"("id")
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY ("notification_id") REFERENCES "NOTIFICATION"("id")
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY ("employee_id") REFERENCES "EMPLOYEE"("id")
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "BALANCE" (
    "id" INTEGER NOT NULL,
    "employee_id" INTEGER,
    "total_days" INTEGER,
    "used_days" INTEGER,
    "days_remaining" INTEGER,
    "updated_at" DATETIME,
    PRIMARY KEY("id")
);
