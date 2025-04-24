package HospitalReservas.Hospital_Reservas.Repository;

import HospitalReservas.Hospital_Reservas.Modal.Notificaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotificacionesRepository extends JpaRepository<Notificaciones, Long> {

    Optional<Notificaciones> findByIdNotificacion(Long idNotificacion);
    Optional<Notificaciones> findByTipoNotificacion(String tipoNotificacion);
}