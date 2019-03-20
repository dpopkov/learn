create table Student
(
  ssn       char(9),
  firstName varchar(25),
  mi        char(1),
  lastName  varchar(25),
  birthDate date,
  street    varchar(25),
  phone     char(11),
  zipCode   char(5),
  deptId    char(4),
  primary key (ssn)
);
