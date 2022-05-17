package lt.vtmc.restapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FilmsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmsApiApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner initalData() {
		return (args)->{
			
		};
	}

}
