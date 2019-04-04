drop table if exists tbl_account;

create table tbl_account(
  id number(12) primary  key  not null ,
  name varchar not null,
  age int(2) not null ,
  sex char(2) not null ,
  password varchar(80) not null ,
  role varchar(10) not null
);