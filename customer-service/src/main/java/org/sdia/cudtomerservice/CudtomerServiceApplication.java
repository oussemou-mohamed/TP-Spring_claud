package org.sdia.cudtomerservice;

import org.sdia.cudtomerservice.entities.Customer;
import org.sdia.cudtomerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CudtomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CudtomerServiceApplication.class, args);

	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration) {
		restConfiguration.exposeIdsFor(Customer.class);
		return args -> {
			customerRepository.save(new Customer(null, "Enset", "contact@enset-media.ma"));
			customerRepository.save(new Customer(null, "FSTM", "contact@fstm.ma"));
			customerRepository.save(new Customer(null, "ENSAM", "contact@ensam.ma"));
			customerRepository.findAll().forEach(c -> {
				System.out.println(c.toString());
			});

		};

	}
}
