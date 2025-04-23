package HospitalReservas.Hospital_Reservas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "HospitalReservas.Hospital_Reservas")
@EntityScan(basePackages = "HospitalReservas.Hospital_Reservas.Modal")
@EnableJpaRepositories(basePackages = "HospitalReservas.Hospital_Reservas.Repository")
public class HospitalReservasApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalReservasApplication.class, args);
	}

}

