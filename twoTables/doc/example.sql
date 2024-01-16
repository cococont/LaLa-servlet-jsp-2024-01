-- database: twoTables
-- user: sa
-- password: (empty)


CREATE USER 'sa'@'localhost' IDENTIFIED BY '';
GRANT ALL ON example.* to 'sa'@'localhost';

CREATE DATABASE IF NOT EXISTS example;
USE example;


-- create dept table
DROP TABLE IF EXISTS dept;

CREATE TABLE dept (
  id CHAR(3) PRIMARY KEY,
  name VARCHAR(20) NOT NULL
);

INSERT INTO dept
  (id, name)
VALUES
  ('D91', '総務部'),
  ('D92', '経理部'),
  ('D93', '営業部'),
  ('D94', '企画部');


-- create employees table
DROP TABLE IF EXISTS employees;

CREATE TABLE employees (
  id CHAR(6) PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  age INT NOT NULL,
  dept_id CHAR(3)
);

ALTER TABLE employees
  ADD CONSTRAINT fk_dept_id
  FOREIGN KEY (dept_id)
  REFERENCES dept(id);

INSERT INTO employees
  (id, name, age, dept_id)
VALUES
  ('EMP001', '湊 雄輔', 23, 'D91'),
  ('EMP002', '綾部 めぐみ', 22, 'D93');

SELECT * FROM employees;

SELECT
  e.id AS id,
  e.name AS name,
  e.age AS age,
  d.id AS dept_id,
  d.name AS dept_name
FROM employees e
  LEFT OUTER JOIN dept d
  ON e.dept_id = d.id
ORDER BY e.id;