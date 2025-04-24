package HospitalReservas.Hospital_Reservas.Controller;

import HospitalReservas.Hospital_Reservas.Modal.Notificaciones;
import HospitalReservas.Hospital_Reservas.Service.NotificacionesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionesController {

    @Autowired
    private NotificacionesService notificacionesService;

    @GetMapping
    public ResponseEntity<List<Notificaciones>> listarNotificaciones() {
        return ResponseEntity.ok(notificacionesService.listarNotificaciones());
    }

    @GetMapping("/{id_notificacion}")
    public ResponseEntity<Notificaciones> obtenerNotificacionPorId(@PathVariable("id_notificacion") Long idNotificacion) {
        Optional<Notificaciones> notificacion = notificacionesService.findByIdNotificacion(idNotificacion);
        return notificacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Notificaciones> crearNotificacion(@RequestBody Notificaciones notificaciones) {
        Notificaciones nuevaNotificacion = notificacionesService.saveNotificacion(notificaciones);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaNotificacion);
    }

    @PutMapping("/{id_notificacion}")
    public ResponseEntity<Notificaciones> actualizarNotificacion(@PathVariable Long id_notificacion, @RequestBody Notificaciones notificacionActualizada) {
        Optional<Notificaciones> notificacion = notificacionesService.actualizarNotificacion(id_notificacion, notificacionActualizada);
        return notificacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id_notificacion}")
    public ResponseEntity<Void> eliminarNotificacion(@PathVariable Long id_notificacion) {
        if (notificacionesService.deleteNotificacion(id_notificacion)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}