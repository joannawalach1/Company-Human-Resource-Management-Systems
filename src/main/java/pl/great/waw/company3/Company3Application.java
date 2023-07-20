package pl.great.waw.company3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Company3Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Company3Application.class, args);
    }
}