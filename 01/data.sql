DROP DATABASE IF EXISTS javaee;
CREATE DATABASE javaee DEFAULT CHARACTER SET utf8;;
USE javaee;
CREATE TABLE news_inf
(
 news_id INT AUTO_INCREMENT PRIMARY KEY,
 news_title VARCHAR(255)
);

INSERT INTO news_inf
VALUES
(NULL, '���Java����'),
(NULL, 'crazyit.org');