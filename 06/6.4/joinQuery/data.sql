﻿drop database if exists hibernate;

create database hibernate;

use hibernate;

CREATE TABLE event_inf (
  event_id int(11) PRIMARY KEY auto_increment ,
  happenDate date default NULL,
  title varchar(255) default NULL
);

INSERT INTO event_inf VALUES
(1,'2004-10-03','很高兴的事情'),
(2,'2005-10-03','很普通的事情'),
(3,'2004-10-04','疯狂Java筹备中'),
(4,'2005-10-05','疯狂Java开始培训');

CREATE TABLE person_inf (
  person_id int(11) PRIMARY KEY auto_increment,
  name varchar(255) default NULL,
  age int(11) default NULL,
  event_id int(11),
  FOREIGN KEY (event_id) REFERENCES event_inf(event_id)
);

INSERT INTO person_inf VALUES
(1,'crazyit.org',30 , 1),
(2,'老朱',30 , 1);


CREATE TABLE person_email (
  person_id int(11) NOT NULL,
  email_detail varchar(255) default NULL,
  FOREIGN KEY (person_id) REFERENCES person_inf (person_id)
);

INSERT INTO person_email VALUES 
(1,'crazyit@crazyit.org'),
(1,'crazyit@fkit.com'),
(2,'dddd@163.com'),
(2,'vvvvvv@163.com');
