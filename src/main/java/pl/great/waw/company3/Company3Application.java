package pl.great.waw.company3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Company3Application {

	public static void main(String[] args) {
		SpringApplication.run(Company3Application.class, args);
	}

}
