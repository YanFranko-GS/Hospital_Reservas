package HospitalReservas.Hospital_Reservas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import HospitalReservas.Hospital_Reservas.Modal.ERol;
import HospitalReservas.Hospital_Reservas.Modal.Rol;
import HospitalReservas.Hospital_Reservas.Repository.RolRepository;


@SpringBootApplication

public class HospitalReservasApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalReservasApplication.class, args);
	}

	@Bean
    public CommandLineRunner initRoles(RolRepository rolRepository) {
        return args -> {
            if (rolRepository.count() == 0) {
                Rol adminRole = new Rol();
                adminRole.setNombre(ERol.ROLE_ADMIN);
                rolRepository.save(adminRole);

                Rol userRole = new Rol();
                userRole.setNombre(ERol.ROLE_USER);
                rolRepository.save(userRole);
            }
        };
    }
}

