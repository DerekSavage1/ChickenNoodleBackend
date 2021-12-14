
DROP TABLE time_range;
CREATE TABLE time_range (
      id BIGINT NOT NULL PRIMARY KEY,
      employee_id UUID NOT NULL,
      start_time TIMESTAMP NOT NULL,
      end_time TIMESTAMP NOT NULL,
      purpose VARCHAR(50) NOT NULL
);