-- ============================================================
-- Task 5: fixed-schema experiments.
-- Execute EACH statement individually. Statements 1-8 must fail.
-- ============================================================

USE university_db;

-- 1. Unknown column (must fail)
INSERT INTO student (student_code, full_name, email, phone)
VALUES ('S010', 'Test One', 'test1@example.com', '0771234567');

-- 2. Missing NOT NULL column (must fail)
INSERT INTO student (student_code, full_name)
VALUES ('S011', 'Test Two');

-- 3. Wrong data type (must fail)
INSERT INTO course (code, title, credits, lecturer_id)
VALUES ('CS301', 'Test Course', 'three', 1);

-- 4. Duplicate UNIQUE value (must fail)
INSERT INTO student (student_code, full_name, email)
VALUES ('S001', 'Test Three', 'test3@example.com');

-- 5. Value too long for VARCHAR(10) (must fail)
INSERT INTO department (code, name)
VALUES ('D0000000001', 'Too Long Code');

-- 6. Foreign key points at no course (must fail)
INSERT INTO enrollment (student_id, course_id, grade)
VALUES (1, 999, 'A');

-- 7. Department D01 still has lecturers (must fail)
DELETE FROM department
WHERE code = 'D01';

-- 8. CHECK constraint credits BETWEEN 1 AND 6 (must fail)
INSERT INTO course (code, title, credits, lecturer_id)
VALUES ('CS302', 'Test Course', 10, 1);

-- Intentional schema change: existing students receive NULL for phone.
ALTER TABLE student ADD COLUMN phone VARCHAR(15);
DESCRIBE student;
SELECT * FROM student;

-- Restore the schema required by the JPA application.
ALTER TABLE student DROP COLUMN phone;
