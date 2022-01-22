DROP TABLE IF EXISTS students CASCADE;
CREATE TABLE students (id bigserial PRIMARY KEY, name VARCHAR(255), mark INT);
INSERT INTO students (name, mark) VALUES
('Alexander', 3),
('Bob', 3),
('Rob', 4),
('Peter', 5),
('John', 3);