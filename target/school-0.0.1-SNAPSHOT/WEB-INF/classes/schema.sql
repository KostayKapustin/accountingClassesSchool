DROP TABLE IF EXISTS class CASCADE;
DROP TABLE IF EXISTS student CASCADE;
DROP TABLE IF EXISTS teacher CASCADE;

CREATE TABLE IF NOT EXISTS teacher
(
    teacher_id  BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    surname     VARCHAR(50)                             NOT NULL,
    firstName   VARCHAR(50)                             NOT NULL,
    patronymic  VARCHAR(50)                             NOT NULL,
    yearBirth   BIGINT                                  NOT NULL,
    mainSubject VARCHAR(50)                             NOT NULL,
    CONSTRAINT pk_teacher PRIMARY KEY (teacher_id)
);

CREATE TABLE IF NOT EXISTS class
(
    class_id     BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    yearStudy    BIGINT                                  NOT NULL,
    mnemonicCode BIGINT                                  NOT NULL UNIQUE,
    teacher_id   BIGINT REFERENCES teacher (teacher_id) ON DELETE CASCADE,
    CONSTRAINT pk_class_id PRIMARY KEY (class_id)
);

CREATE TABLE IF NOT EXISTS student
(
    student_id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    surname    VARCHAR(50)                             NOT NULL,
    firstName  VARCHAR(50)                             NOT NULL,
    patronymic VARCHAR(50)                             NOT NULL,
    yearBirth  BIGINT                                  NOT NULL,
    gender     VARCHAR(50)                             NOT NULL,
    CONSTRAINT pk_student PRIMARY KEY (student_id)
);
