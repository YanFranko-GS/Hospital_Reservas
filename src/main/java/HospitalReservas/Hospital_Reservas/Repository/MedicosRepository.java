package HospitalReservas.Hospital_Reservas.Repository;

import HospitalReservas.Hospital_Reservas.Modal.Medicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicosRepository extends JpaRepository<Medicos, Long> {

    Optional<Medicos> findByIdMedico(Long idMedico);
    Optional<Medicos> findByEspecialidad(String especialidad);
    Optional<Medicos> findByNumeroColegiado(String numeroColegiado);
    Optional<Medicos> findByCorreoElectronico(String correoElectronico);
}