create table Enrollment
(
  ssn            char(9),
  courseId       char(5),
  dateRegistered date,
  grade          char(1),
  primary key (ssn, courseId),
  foreign key (ssn) references Student (ssn),
  foreign key (courseId) references Course (courseId)
);
