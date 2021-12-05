CREATE TABLE employee (
      id UUID NOT NULL PRIMARY KEY,
      name VARCHAR(100) NOT NULL,
      email VARCHAR(100) NOT NULL,
      jobTitle VARCHAR(100) NOT NULL,
      phone VARCHAR(10) NOT NULL,
      imageUrl VARCHAR(200) NOT NULL
);