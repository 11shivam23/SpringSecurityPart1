CREATE database BankApp;

CREATE TABLE users (
    username VARCHAR(50) COLLATE utf8mb4_general_ci NOT NULL PRIMARY KEY,
    password VARCHAR(500) COLLATE utf8mb4_general_ci NOT NULL,
    enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities (
    username VARCHAR(50) COLLATE utf8mb4_general_ci NOT NULL,
    authority VARCHAR(50) COLLATE utf8mb4_general_ci NOT NULL,
    CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users(username)
);

CREATE UNIQUE INDEX ix_auth_username ON authorities (username, authority);

--2--------------------------------------------------------------------------------------

CREATE TABLE customer (
	`id` int NOT NULL AUTO_INCREMENT,
    `email` varchar(45) NOT NULL,
    `pwd` varchar(200) NOT NULL,
    `role` varchar(15) NOT NULL,
    PRIMARY KEY (`id`)
);

INSERT INTO `customer` (`email`,`pwd`,`role`)
VALUES ('email@gmail.com','1234','admin');
