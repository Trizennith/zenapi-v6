CREATE SEQUENCE IF NOT EXISTS user_sessions_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS users_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE user_sessions
(
    id            INTEGER      NOT NULL,
    user_id       INTEGER,
    session_token VARCHAR(255) NOT NULL,
    client_ip     VARCHAR(255),
    user_agent    VARCHAR(255),
    issued_at     TIMESTAMP WITHOUT TIME ZONE,
    expires_at    TIMESTAMP WITHOUT TIME ZONE,
    created_at    TIMESTAMP WITHOUT TIME ZONE,
    updated_at    TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_user_sessions PRIMARY KEY (id)
);

CREATE TABLE users
(
    id         INTEGER      NOT NULL,
    full_name  VARCHAR(255) NOT NULL,
    email      VARCHAR(100) NOT NULL,
    password   VARCHAR(255) NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    role       VARCHAR(255) NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE user_sessions
    ADD CONSTRAINT uc_user_sessions_session_token UNIQUE (session_token);

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);

ALTER TABLE user_sessions
    ADD CONSTRAINT FK_USER_SESSIONS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);