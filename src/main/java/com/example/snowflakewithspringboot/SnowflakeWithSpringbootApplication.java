package com.example.snowflakewithspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SnowflakeWithSpringbootApplication {

    public static void main(String[] args) {
        String Query = "CREATE TABLE Persons ( " +
                "    PersonID int, " +
                "    LastName varchar(255), " +
                "    FirstName varchar(255), " +
                "    Address varchar(255), " +
                "    City varchar(255) " +
                ");";
        SnowflakeService.executeQuery(Query);
        SpringApplication.run(SnowflakeWithSpringbootApplication.class, args);
    }

}
