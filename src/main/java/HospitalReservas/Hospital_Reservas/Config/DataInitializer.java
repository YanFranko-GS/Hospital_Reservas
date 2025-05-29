package HospitalReservas.Hospital_Reservas.Config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import HospitalReservas.Hospital_Reservas.Modal.ERol;
import HospitalReservas.Hospital_Reservas.Modal.Rol;
import HospitalReservas.Hospital_Reservas.Repository.RolRepository;


@Component
public class DataInitializer implements CommandLineRunner {

    private final RolRepository rolRepository;

    public DataInitializer(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (rolRepository.count() == 0) {
            Rol rolAdmin = new Rol();
            rolAdmin.setNombre(ERol.ROLE_ADMIN);
            rolRepository.save(rolAdmin);
            
            Rol rolUser = new Rol();
            rolUser.setNombre(ERol.ROLE_USER);
            rolRepository.save(rolUser);
        }
    }
}