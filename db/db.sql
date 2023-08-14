drop database if exists nighthawk;

CREATE DATABASE nighthawk ENCODING 'UTF8';

\c nighthawk

CREATE TABLE users (
    id        SERIAL        PRIMARY KEY,
    name      VARCHAR(100)  NOT     NULL,
    lastname  VARCHAR(100)  NOT     NULL,
    age       SMALLINT      NOT     NULL,
    birthdate DATE          NOT     NULL,
    available BOOLEAN       DEFAULT TRUE
);

CREATE TABLE account (
    id               SERIAL       PRIMARY KEY,
    username        VARCHAR(100) NOT     NULL,
    password        VARCHAR(100) NOT     NULL,
    available        BOOLEAN     DEFAULT TRUE,
    user_id          INT          NOT     NULL,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

INSERT INTO users   (name, lastname, age, birthdate) VALUES ('Jane', 'Doe', 30, '1993-08-13');
INSERT INTO account (username, password, user_id)    VALUES ('admin', '$2a$10$wRS33vhVq3fz2bzDYkDcru0UkmPJmDzRrR4P5oauwtdM5OSRMzkgK', 1);
