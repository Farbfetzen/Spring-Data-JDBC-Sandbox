CREATE TABLE author (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL,
    username VARCHAR(100) NOT NULL
);

CREATE TABLE post (
    id INT AUTO_INCREMENT PRIMARY KEY,
    version INT,
    title VARCHAR(255) NOT NULL,
    content text NOT NULL,
    published_on TIMESTAMP NOT NULL,
    updated_on TIMESTAMP,
    author INT,
    FOREIGN KEY (author) REFERENCES author(id)
);

CREATE TABLE comment (
    post INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    content text NOT NULL,
    published_on TIMESTAMP NOT NULL,
    updated_on TIMESTAMP,
    FOREIGN KEY (post) REFERENCES post(id)
);

CREATE TABLE account (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE role (
    account INT NOT NULL,
    name VARCHAR(30) NOT NULL,
    FOREIGN KEY (account) REFERENCES account(id)
);
