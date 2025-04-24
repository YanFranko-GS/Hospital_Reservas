package HospitalReservas.Hospital_Reservas.Service;

import HospitalReservas.Hospital_Reservas.Modal.Notificaciones;
import HospitalReservas.Hospital_Reservas.Repository.NotificacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificacionesService {

    @Autowired
    private NotificacionesRepository notificacionesRepository;

    public Optional<Notificaciones> findByIdNotificacion(Long idNotificacion) {
        return notificacionesRepository.findByIdNotificacion(idNotificacion);
    }

    public Optional<Notificaciones> findByTipoNotificacion(String tipoNotificacion) {
        return notificacionesRepository.findByTipoNotificacion(tipoNotificacion);
    }

    public Notificaciones saveNotificacion(Notificaciones notificaciones) {
        return notificacionesRepository.save(notificaciones);
    }

    public List<Notificaciones> listarNotificaciones() {
        return notificacionesRepository.findAll();
    }

    public Optional<Notificaciones> actualizarNotificacion(Long idNotificacion, Notificaciones actualizado) {
        return notificacionesRepository.findById(idNotificacion).map(n -> {
            n.setTipoNotificacion(actualizado.getTipoNotificacion());
            n.setFechaEnvio(actualizado.getFechaEnvio());
            n.setMedioEnvio(actualizado.getMedioEnvio());
            n.setMensaje(actualizado.getMensaje());
            return notificacionesRepository.save(n);
        });
    }

    public boolean deleteNotificacion(Long idNotificacion) {
        if (notificacionesRepository.existsById(idNotificacion)) {
            notificacionesRepository.deleteById(idNotificacion);
            return true;
        }
        return false;
    }
}