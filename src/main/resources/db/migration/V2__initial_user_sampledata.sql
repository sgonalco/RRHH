-- Roles
INSERT INTO ROLE (id, title) VALUES
    (1, 'ADMIN'),
    (2, 'MANAGER'),
    (3, 'EMPLOYEE'),
    (4, 'HR');

-- Users
INSERT INTO USER (id, username, password, email, status, created_at, updated_at) VALUES
    (1, 'admin', 'admin123', 'admin@example.com', 'ACTIVE', '2025-01-01 09:00:00', '2025-01-01 09:00:00'),
    (2, 'jdoe', 'password123', 'john.doe@example.com', 'ACTIVE', '2025-02-15 10:30:00', '2025-02-15 10:30:00'),
    (3, 'asmith', 'welcome123', 'anna.smith@example.com', 'INACTIVE', '2025-03-01 14:45:00', '2025-03-01 14:45:00'),
    (4, 'bjones', 'secret456', 'bob.jones@example.com', 'ACTIVE', '2025-03-20 08:15:00', '2025-03-20 08:15:00'),
    (5, 'cmiller', 'test789', 'carol.miller@example.com', 'SUSPENDED', '2025-04-10 16:00:00', '2025-04-10 16:00:00');

-- User ↔ Role relationships
INSERT INTO USER_ROLES (user_id, role_id) VALUES
-- admin has ADMIN and HR
    (1, 1),
    (1, 4),

    -- jdoe is EMPLOYEE
    (2, 3),

    -- asmith is MANAGER
    (3, 2),

    -- bjones is EMPLOYEE and HR
    (4, 3),
    (4, 4),

    -- cmiller is EMPLOYEE
    (5, 3);