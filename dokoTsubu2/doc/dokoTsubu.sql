CREATE TABLE mutters (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  text VARCHAR(255) NOT NULL
);

INSERT INTO mutters
  (name, text)
VALUES
  ('湊', '今日は休みだ'),
  ('綾部', 'いいな');