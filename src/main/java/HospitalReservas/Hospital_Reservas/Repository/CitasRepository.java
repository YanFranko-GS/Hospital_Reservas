package HospitalReservas.Hospital_Reservas.Repository;

import HospitalReservas.Hospital_Reservas.Modal.Citas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CitasRepository extends JpaRepository<Citas, Long> {

    Optional<Citas> findByIdCita(Long idCita);
    Optional<Citas> findByFechaHora(String fechaHora);
    Optional<Citas> findByEstado(String estado);
    Optional<Citas> findByMotivo(String motivo);

}