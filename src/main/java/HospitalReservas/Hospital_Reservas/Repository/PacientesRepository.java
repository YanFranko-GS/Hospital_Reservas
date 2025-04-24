package HospitalReservas.Hospital_Reservas.Repository;

import HospitalReservas.Hospital_Reservas.Modal.Pacientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacientesRepository extends JpaRepository<Pacientes, Long> {

    Optional<Pacientes> findByIdPaciente(Long idPaciente);
    Optional<Pacientes> findByCorreoElectronico(String correoElectronico);
    Optional<Pacientes> findByTelefono(int telefono);
    Optional<Pacientes> findByNumeroDocumento(String numeroDocumento);
    Optional<Pacientes> findByHistorialMedico(Long historialMedico);
}
