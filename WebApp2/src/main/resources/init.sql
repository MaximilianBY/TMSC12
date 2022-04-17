-- DDL for schema students

DROP SCHEMA IF EXISTS students;
CREATE SCHEMA IF NOT EXISTS students;

DROP TABLE IF EXISTS students.students_db, students.students_city_db;
CREATE TABLE IF NOT EXISTS students.students_db
(
    id         INT         NOT NULL AUTO_INCREMENT UNIQUE,
    first_name varchar(50) NOT NULL,
    last_name  varchar(50) NOT NULL,
    course     INT         NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS students.students_city_db
(
    id          INT         NOT NULL AUTO_INCREMENT,
    students_id INT         NOT NULL,
    city_from   varchar(50) NOT NULL,
    city_study  varchar(50) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (students_id) REFERENCES students_db (id) ON DELETE CASCADE,
    FOREIGN KEY (students_id) REFERENCES students_db (id) ON UPDATE CASCADE,
    FOREIGN KEY (students_id) REFERENCES students_db (id)
);

-- DML for Table students_db

INSERT INTO students.students_db(first_name, last_name, course) value ('Ivan', 'Petrov', 6);
INSERT INTO students.students_db(first_name, last_name, course) value ('Jack', 'Johnson', 4);
INSERT INTO students.students_db(first_name, last_name, course) value ('Samuel', 'Lee', 2);
INSERT INTO students.students_db(first_name, last_name, course) value ('Daniel', 'Jackson', 2);
INSERT INTO students.students_db(first_name, last_name, course) value ('Dmitriy', 'Sergeev', 3);
INSERT INTO students.students_db(first_name, last_name, course) value ('Anna', 'Popova', 5);

-- DML for Table students_city_db

INSERT INTO students.students_city_db(students_id, city_from, city_study) value (1, 'Izevsk', 'Moscow');
INSERT INTO students.students_city_db(students_id, city_from, city_study) value (2, 'LA', 'NY');
INSERT INTO students.students_city_db(students_id, city_from, city_study) value (3, 'LA', 'Washington');
INSERT INTO students.students_city_db(students_id, city_from, city_study) value (4, 'NY', 'Mogilev');
INSERT INTO students.students_city_db(students_id, city_from, city_study) value (5, 'Gomel', 'Vitebsk');
INSERT INTO students.students_city_db(students_id, city_from, city_study) value (6, 'Molodzechno', 'Minsk');