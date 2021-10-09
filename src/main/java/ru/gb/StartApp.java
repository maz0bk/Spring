package ru.gb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.gb.service.DateBaseConnection;

@SpringBootApplication()
public class StartApp  {

    public static void main(String[] args) {
        SpringApplication.run(StartApp.class,args);
    }
}
