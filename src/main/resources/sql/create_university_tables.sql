CREATE TABLE "faculty" (
  "id" SERIAL PRIMARY KEY,
  "faculty_name" varchar
);

CREATE TABLE "student_group" (
  "id" SERIAL PRIMARY KEY,
  "group_name" varchar,
  "faculty_id" int
);

CREATE TABLE "department" (
  "id" SERIAL PRIMARY KEY,
  "department_name" varchar,
  "faculty_id" int
);

CREATE TABLE "student" (
  "id" SERIAL PRIMARY KEY,
  "student_name" varchar,
  "student_surname" varchar,
  "age" int,
  "student_group_id" int
);

CREATE TABLE "teacher" (
  "id" SERIAL PRIMARY KEY,
  "teacher_name" varchar,
  "teacher_surname" varchar,
  "age" int,
  "department_id" int
);

CREATE TABLE "schedule_time" (
  "id" SERIAL PRIMARY KEY,
  "begin_time" timestamp,
  "end_time" timestamp
);

CREATE TABLE "classroom" (
  "id" SERIAL PRIMARY KEY,
  "classroom_name" varchar,
  "classroom_number" int
);

CREATE TABLE "schedule_item" (
  "id" SERIAL PRIMARY KEY,
  "schedule_time_id" int,
  "classroom_id" int,
  "department_id" int,
  "teacher_id" int
);

ALTER TABLE "student_group" ADD FOREIGN KEY ("faculty_id") REFERENCES "faculty" ("id");

ALTER TABLE "department" ADD FOREIGN KEY ("faculty_id") REFERENCES "faculty" ("id");

ALTER TABLE "student" ADD FOREIGN KEY ("student_group_id") REFERENCES "student_group" ("id");

ALTER TABLE "teacher" ADD FOREIGN KEY ("department_id") REFERENCES "department" ("id");

ALTER TABLE "schedule_item" ADD FOREIGN KEY ("schedule_time_id") REFERENCES "schedule_time" ("id");

ALTER TABLE "schedule_item" ADD FOREIGN KEY ("schedule_time_id") REFERENCES "classroom" ("id");

ALTER TABLE "schedule_item" ADD FOREIGN KEY ("schedule_time_id") REFERENCES "teacher" ("id");

ALTER TABLE "schedule_item" ADD FOREIGN KEY ("schedule_time_id") REFERENCES "student_group" ("id");
