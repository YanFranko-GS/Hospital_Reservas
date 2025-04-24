package HospitalReservas.Hospital_Reservas.Repository;

import HospitalReservas.Hospital_Reservas.Modal.HorarioDisponibles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HorariosDisponiblesRepository extends JpaRepository<HorarioDisponibles, Long> {

    Optional<HorarioDisponibles> findByIdHorario(Long idHorario);
    Optional<HorarioDisponibles> findByFechaDisponibilidad(String fechaDisponibilidad);
    Optional<HorarioDisponibles> findByEstado(String estado);
}