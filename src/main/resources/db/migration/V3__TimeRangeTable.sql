CREATE TABLE time_range (
      id NUMERIC NOT NULL PRIMARY KEY,
      employee_id UUID NOT NULL,
      start_time DATE NOT NULL,
      end_time DATE NOT NULL,
      purpose VARCHAR(50) NOT NULL
);