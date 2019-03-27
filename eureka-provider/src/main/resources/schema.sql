  drop table if exists tbl_book;

  create table tbl_book(
  id number(12) primary key not null,
  name varchar not null,
  price decimal not null
  );

  create table t_user(
  id number(12) primary key not null,
  name varchar not null,
  age int not null
  );

 -- DELETE FROM tbl_book;