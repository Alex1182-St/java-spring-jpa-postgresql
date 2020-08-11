package com.java.javaspringjpapostgresql;


import com.java.javaspringjpapostgresql.entities.RoleEntity;
import com.java.javaspringjpapostgresql.entities.RoleEnum;
import com.java.javaspringjpapostgresql.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;

@SpringBootApplication
public class JavaSpringJpaPostgresqlApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringJpaPostgresqlApplication.class, args);
	}


	@Autowired
	RoleRepository roleRepo;

	@Transactional
	@Override
	public void run(String... args) throws Exception {

		RoleEntity roleEntity = new RoleEntity();
		roleEntity.setName(RoleEnum.USER);

		roleRepo.save(roleEntity);
	}
}
