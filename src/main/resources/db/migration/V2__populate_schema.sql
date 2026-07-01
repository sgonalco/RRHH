-- =====================================================
-- 1. USERS
-- =====================================================

INSERT INTO USER (id, username, password, email, created_at, updated_at) VALUES
                                                                             (1,'admin','admin123','admin@company.com','2026-01-01 09:00:00','2026-01-01 09:00:00'),
                                                                             (2,'jdoe','password123','john@company.com','2026-01-01 09:00:00','2026-01-01 09:00:00'),
                                                                             (3,'asmith','password123','anna@company.com','2026-01-01 09:00:00','2026-01-01 09:00:00');

-- =====================================================
-- 2. ROLES
-- =====================================================

INSERT INTO ROLE (id,name) VALUES
                               (1,'Administrator'),
                               (2,'Manager'),
                               (3,'Employee');

INSERT INTO USER_ROLES (user_id, role_id) VALUES
                                              (1,1),
                                              (2,2),
                                              (3,3);

-- =====================================================
-- 3. DEPARTMENTS (manager_id initially NULL)
-- =====================================================

INSERT INTO DEPARTMENT
(id,name,description,manager_id,created_at,updated_at)
VALUES
    (1,'Human Resources','Employee management',NULL,'2026-01-01','2026-01-01'),
    (2,'IT','Technology department',NULL,'2026-01-01','2026-01-01');

-- =====================================================
-- 4. GOALS
-- =====================================================

INSERT INTO GOAL
(id,title,description,status,start_date,end_date)
VALUES
    (1,'Reduce turnover','Lower employee turnover','Active','2026-01-01','2026-12-31'),
    (2,'Upgrade infrastructure','Replace legacy servers','In Progress','2026-02-01','2026-09-30');

INSERT INTO DEPARTMENT_GOALS VALUES
                                 (1,1),
                                 (2,2);

-- =====================================================
-- 5. EMPLOYEES
-- =====================================================

INSERT INTO EMPLOYEE
(id,first_name,last_name,dni,birthdate,phone_number,email,address,
 hire_date,salary,department_id,position,status,user_id)
VALUES
    (1,'John','Doe','12345678A','1990-05-12',
     '555-1001','john@company.com','123 Main St',
     '2023-01-15',5000,1,'HR Manager','Active',2),

    (2,'Anna','Smith','87654321B','1995-08-20',
     '555-1002','anna@company.com','456 Oak Ave',
     '2024-03-10',4200,2,'Software Engineer','Active',3);

-- Assign managers after employees exist

UPDATE DEPARTMENT
SET manager_id = 1
WHERE id = 1;

UPDATE DEPARTMENT
SET manager_id = 2
WHERE id = 2;

-- =====================================================
-- 6. BENEFITS
-- =====================================================

INSERT INTO BENEFIT VALUES
                        (1,'Health Insurance','Private insurance',300),
                        (2,'Transportation','Monthly allowance',100);

INSERT INTO EMPLOYEE_BENEFITS VALUES
                                  (1,1),
                                  (1,2),
                                  (2,1);

-- =====================================================
-- 7. DEDUCTIONS
-- =====================================================

INSERT INTO DEDUCTION VALUES
                          (1,'Income Tax','Government tax',500),
                          (2,'Social Security','Mandatory contribution',250);

INSERT INTO EMPLOYEE_DEDUCTIONS VALUES
                                    (1,1),
                                    (1,2),
                                    (2,1),
                                    (2,2);

-- =====================================================
-- 8. SALARY HISTORY
-- =====================================================

INSERT INTO SALARY
(id,employee_id,old_salary,new_salary,change_date,reason)
VALUES
    (1,1,4500,5000,'2025-01-01','Annual raise'),
    (2,2,4000,4200,'2025-06-01','Performance review');

-- =====================================================
-- 9. PAYROLL
-- =====================================================

INSERT INTO PAYROLL
(id,employee_id,month,year,base,gross,net,payment_date,status)
VALUES
    (1,1,'January',2026,5000,5400,4650,'2026-01-31','Paid'),
    (2,2,'January',2026,4200,4500,3900,'2026-01-31','Paid');

-- =====================================================
-- 10. RECEIPTS
-- =====================================================

INSERT INTO RECEIPT
(id,payroll_id,concept,amount,type)
VALUES
    (1,1,'Base Salary',5000,'Income'),
    (2,1,'Income Tax',500,'Deduction'),
    (3,2,'Base Salary',4200,'Income'),
    (4,2,'Income Tax',500,'Deduction');

-- =====================================================
-- 11. REPORTS
-- =====================================================

INSERT INTO REPORT
(id,receipt_id,month,year)
VALUES
    (1,1,'January',2026),
    (2,3,'January',2026);

-- =====================================================
-- 12. ABSENCES
-- =====================================================

INSERT INTO ABSENCE
(id,employee_id,start_date,end_date,type,reason,status,created_at)
VALUES
    (1,2,'2026-02-10','2026-02-12',
     'Sick Leave','Flu','Approved','2026-02-09 09:00:00');

-- =====================================================
-- 13. LEAVE REQUESTS
-- =====================================================

INSERT INTO REQUEST
(id,employee_id,days_requested,start_date,end_date,reason,status,created_at)
VALUES
    (1,1,5,
     '2026-04-01',
     '2026-04-05',
     'Family vacation',
     'Approved',
     '2026-03-01 08:30:00');

-- =====================================================
-- 14. NOTIFICATIONS
-- =====================================================

INSERT INTO NOTIFICATION
(id, message, sent_date, read, employee_id)
VALUES
    (1,
     'Your sick leave has been approved.',
     '2026-02-09 10:00:00',
     0,
     2),

    (2,
     'Your vacation request has been approved.',
     '2026-03-02 09:00:00',
     1,
     1);

-- =====================================================
-- 15. ABSENCE NOTIFICATIONS
-- =====================================================

INSERT INTO ABSENCE_NOTIFICATION
(id, absence_id, notification_id)
VALUES
    (1, 1, 1);

-- =====================================================
-- 16. LEAVE NOTIFICATIONS
-- =====================================================

INSERT INTO LEAVE_NOTIFICATION
(id, request_id, notification_id)
VALUES
    (1, 1, 2);

-- =====================================================
-- 17. VACATION BALANCE
-- =====================================================

INSERT INTO BALANCE
(id, employee_id, total_days, used_days, days_remaining, updated_at)
VALUES
    (1,1,25,5,20,'2026-03-02'),
    (2,2,25,2,23,'2026-02-12');