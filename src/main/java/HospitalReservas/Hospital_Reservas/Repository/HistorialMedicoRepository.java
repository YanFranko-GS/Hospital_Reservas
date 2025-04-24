package HospitalReservas.Hospital_Reservas.Repository;

import HospitalReservas.Hospital_Reservas.Modal.HistorialMedicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HistorialMedicoRepository extends JpaRepository<HistorialMedicos, Long> {

    Optional<HistorialMedicos> findByIdHistorial(Long idHistorial);
    Optional<HistorialMedicos> findByDiagnostico(String diagnostico);
}