-- ===========================
-- TABLE: USERS
-- ===========================
CREATE TABLE USERS (
                       id INTEGER PRIMARY KEY AUTOINCREMENT,
                       username TEXT NOT NULL UNIQUE,
                       password TEXT NOT NULL,
                       email TEXT NOT NULL UNIQUE,
                       created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- ===========================
-- TABLE: ROLES
-- ===========================
CREATE TABLE ROLES (
                       id INTEGER PRIMARY KEY AUTOINCREMENT,
                       name TEXT NOT NULL UNIQUE
);

-- ===========================
-- TABLE: USER_ROLES
-- ===========================
CREATE TABLE USER_ROLES (
                            user_id INTEGER NOT NULL,
                            role_id INTEGER NOT NULL,

                            PRIMARY KEY (user_id, role_id),

                            FOREIGN KEY (user_id)
                                REFERENCES USERS(id)
                                ON DELETE NO ACTION
                                ON UPDATE NO ACTION,

                            FOREIGN KEY (role_id)
                                REFERENCES ROLES(id)
                                ON DELETE NO ACTION
                                ON UPDATE NO ACTION
);