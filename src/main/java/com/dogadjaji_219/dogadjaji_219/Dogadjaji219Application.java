package com.dogadjaji_219.dogadjaji_219;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dogadjaji_219.dogadjaji_219.models.entities.Role;
import com.dogadjaji_219.dogadjaji_219.models.entities.User;
import com.dogadjaji_219.dogadjaji_219.models.services.UserService;

@SpringBootApplication
public class Dogadjaji219Application {

	public static void main(String[] args) {
		SpringApplication.run(Dogadjaji219Application.class, args);
	}

	@Bean
	CommandLineRunner runner(UserService _UserService){
		return args -> {
			_UserService.saveRole(new Role(null, "USER"));
			_UserService.saveRole(new Role(null, "ADMIN"));

			_UserService.saveUser(new User(null, "admin@admin.com", "admin", new ArrayList<>()));
			_UserService.saveUser(new User(null, "prvi@user.com", "user1", new ArrayList<>()));
			_UserService.saveUser(new User(null, "drugi@user.com", "user2", new ArrayList<>()));
			_UserService.saveUser(new User(null, "treci@user.com", "user3", new ArrayList<>()));
			
			_UserService.addRoleToUser("admin@admin.com", "ADMIN");
			_UserService.addRoleToUser("prvi@user.com", "USER");
			_UserService.addRoleToUser("drugi@user.com", "USER");
			_UserService.addRoleToUser("treci@user.com", "USER");

		};
	}

}
