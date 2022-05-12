CREATE DATABASE users;
use  users;
create table users(
id varchar(20) not null primary key,
name varchar(250) not null,
password varchar(250) not null
);

insert into users
Values("1","eyob","123");
  insert into users values("2","bereket","tadel");
  insert into users values("3","Abel","zeleke");
select *from users;