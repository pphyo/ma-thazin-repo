# Employee Management

## Before you run, please do this step.

```
mysql -u <user> -p<password>

create database employee_db;

create user 'employee'@'localhost' identified by 'employee';

grant all privileges on employee_db.* to 'employee'@'localhost';

flush privileges;
```

## Run the application
```
mvn spring-boot:run
```