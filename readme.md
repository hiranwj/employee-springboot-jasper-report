# Export pdf with springboot and jasper report

This guide will walk you through the process of integrating JasperReports with Spring Boot to generate PDF reports from a MySQL database. With this setup, you can effortlessly create PDF reports based on your data using JasperReports and Spring Boot.

### MySQL Database Setup
Before we proceed with integrating JasperReports, let's set up a MySQL database and define the necessary table to store employee information. Below are the MySQL queries to create the database, table, and insert sample data:

CREATE DATABASE xdotodb;

CREATE TABLE employee_tbl (
id INT,
name VARCHAR(255),
designation VARCHAR(255),
salary FLOAT,
doj VARCHAR(255)
);

INSERT INTO employee_tbl (id, name, designation, salary, doj)
VALUES
(1, 'Janith', 'SE', 150000, '2022-06-23'),
(2, 'Rupe', 'ARCHI', 500000, '2021-01-06'),
(3, 'Kasun', 'ASE', 125000, '2019-07-14'),
(4, 'Nayana', 'TL', 300000, '2018-09-02'),
(5, 'Hiran', 'SE', 200000, '2020-07-27');

### Copy and paste these urls for generate pdf file

for get employees :
http://localhost:9090/getEmployees

for export pdf :
http://localhost:9090/report/pdf

---
### Authors
- [@hiranwj](https://www.github.com/hiranwj)

