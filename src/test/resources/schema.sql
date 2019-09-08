DROP TABLE IF EXISTS TASKS;
 
CREATE TABLE TASKS (
  id VARCHAR(250) NOT NULL,
  timestamp VARCHAR(250) NOT NULL,
  status VARCHAR(250) DEFAULT NULL
);

INSERT INTO tasks (id, timestamp, status) VALUES('1','2','3');
INSERT INTO tasks (id, timestamp, status) VALUES('2','2','3');
INSERT INTO tasks (id, timestamp, status) VALUES('3','2','3');
INSERT INTO tasks (id, timestamp, status) VALUES('4','2','3');
INSERT INTO tasks (id, timestamp, status) VALUES('5','2','3');