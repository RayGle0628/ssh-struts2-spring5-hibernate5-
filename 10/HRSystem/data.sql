drop database if exists hrSystem;

create database hrSystem;

use hrSystem;

create table attend_type_inf
(
 type_id int auto_increment,
 amerce_amount double not null,
 type_name varchar(50) not null,
 primary key(type_id)
);

create table employee_inf
(
 emp_id int auto_increment,
 emp_type int,
 emp_name varchar(50) not null,
 emp_pass varchar(50) not null,
 emp_salary double not null,
 mgr_id int,
 dept_name varchar(50),
 primary key(emp_id),
 unique key(emp_name),
 foreign key(mgr_id) references employee_inf(emp_id)
);

create table attend_inf
(
 attend_id int auto_increment,
 duty_day varchar(50) not null,
 punch_time datetime,
 is_come boolean not null,
 type_id int not null,
 emp_id int not null,
 primary key(attend_id),
 foreign key(type_id) references attend_type_inf(type_id),
 foreign key(emp_id) references employee_inf(emp_id)
);

create table application_inf
(
 app_id int auto_increment,
 attend_id int not null,
 app_reason varchar(255),
 app_result boolean,
 type_id int not null,
 primary key(app_id),
 foreign key(type_id) references attend_type_inf(type_id),
 foreign key(attend_id) references attend_inf(attend_id)
);

create table  payment_inf
(
 pay_id int auto_increment,
 pay_month varchar(50) not null,
 pay_amount double not null,
 emp_id int not null,
 primary key(pay_id),
 foreign key(emp_id) references employee_inf(emp_id)
);

create table  checkback_inf
(
 check_id int auto_increment,
 app_id int not null,
 check_result boolean not null,
 check_reason varchar(255),
 mgr_id int not null,
 primary key(check_id),
 foreign key(app_id) references application_inf(app_id),
 foreign key(mgr_id) references employee_inf(emp_id)
);

insert into attend_type_inf ( type_name , amerce_amount)
	values ( '����', 0);
insert into attend_type_inf ( type_name , amerce_amount)
	values ( '�¼�', -20);
insert into attend_type_inf ( type_name , amerce_amount)
	values ( '����', -10);
insert into attend_type_inf ( type_name , amerce_amount)
	values ( '�ٵ�', -10);
insert into attend_type_inf ( type_name , amerce_amount)
	values ( '����', -10);
insert into attend_type_inf ( type_name , amerce_amount)
	values ( '����', -30);
insert into attend_type_inf ( type_name , amerce_amount)
	values ( '����', 10);

# ���뾭��
insert into employee_inf (emp_type , emp_name , emp_pass , emp_salary , mgr_id , dept_name)
	values (2, 'oracle', 'oracle' , 5000 , null , 'DB��');
insert into employee_inf (emp_type , emp_name , emp_pass , emp_salary , mgr_id , dept_name)
	values (2, 'weblogic', 'weblogic' , 6000 , null , 'Server��');
# Ա��
insert into employee_inf (emp_type , emp_name , emp_pass , emp_salary , mgr_id)
	values (1 , 'mysql', 'mysql' , 3000 , 1);
insert into employee_inf (emp_type , emp_name , emp_pass , emp_salary , mgr_id)
	values (1 , 'hsql', 'hsql' , 3200 , 1);
insert into employee_inf (emp_type , emp_name , emp_pass , emp_salary , mgr_id)
	values (1 , 'tomcat', 'tomcat' , 2800 , 2);
insert into employee_inf (emp_type , emp_name , emp_pass , emp_salary , mgr_id)
	values (1 , 'jetty', 'jetty' , 2560 , 2);
