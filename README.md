# Custom Schedule Maker

This project is a customized schedule maker designed to help users efficiently create schedules for their employees. 

## Features

- Add employees to a database
- Add time ranges to let employees request time off

## Setup 

- Add Postgres database connection details to 'application.yml' and run the application.

## How to Use

1. Start by adding employees to the database by using the following API mappings:

### Employee API Mappings

- **GET** `/employee/all` : Retrieves all employees
- **GET** `/employee/find/{id}` : Retrieves an employee by ID
- **POST** `/employee/add` : Adds a new employee
- **PUT** `/employee/update/{id}` : Updates an existing employee
- **DELETE** `/employee/delete/{id}` : Deletes an employee by ID

2. Use the TimeRange API mappings to manage schedules:

### TimeRange API Mappings

- **GET** `/schedule/all` : Retrieves all time ranges
- **GET** `/schedule/find/{id}` : Retrieves a time range by ID
- **POST** `/schedule/add` : Adds a new time range
- **PUT** `/schedule/update/{id}` : Updates an existing time range
- **DELETE** `/schedule/delete/{id}` : Deletes a time range by ID

## Contributors

- Derek Savage
