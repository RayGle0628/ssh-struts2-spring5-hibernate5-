drop database hibernate;

create database hibernate;

use hibernate;

create table news_inf
(
 news_id int primary key auto_increment,
 content varchar(255),
 title varchar(255)
);

insert into news_inf
values(null , '���Java����' , '���Java���������ļ�����̳��');

insert into news_inf
values(null , '������' , '��һ�������������磬����Զ�����ң�');
