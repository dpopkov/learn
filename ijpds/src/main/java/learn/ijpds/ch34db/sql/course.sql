create table Course
(
  courseId     char(5),
  subjectId    char(4)     not null,
  courseNumber integer,
  title        varchar(50) not null,
  numOfCredits integer,
  primary key (courseId)
);
