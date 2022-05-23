package lt.vtmc.restapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lt.vtmc.restapi.models.ERole;
import lt.vtmc.restapi.models.Role;
import lt.vtmc.restapi.repository.RoleRepository;

@SpringBootApplication
public class FilmsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmsApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialData(RoleRepository roleRepo) {
		return args -> {
			if (roleRepo.findByName(ERole.ROLE_USER).isEmpty()) {
				roleRepo.save(new Role(ERole.ROLE_USER));
			}
			if (roleRepo.findByName(ERole.ROLE_ADMIN).isEmpty()) {
				roleRepo.save(new Role(ERole.ROLE_ADMIN));
			}
		};
	}

}
