package HospitalReservas.Hospital_Reservas.Controller;

import HospitalReservas.Hospital_Reservas.Modal.Citas;
import HospitalReservas.Hospital_Reservas.Service.CitasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/citas")
public class CitasController {

    @Autowired
    private CitasService citasService;

    // GET: Listar todas las citas
    @GetMapping
    public ResponseEntity<List<Citas>> listarCitas() {
        return ResponseEntity.ok(citasService.listarCitas());
    }

    // GET: Buscar cita por ID
    @GetMapping("/{id_cita}")
    public ResponseEntity<Citas> obtenerCitaPorId(@PathVariable("id_cita") Long idCita) {
        Optional<Citas> cita = citasService.findByIdCita(idCita);
        return cita.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST: Crear nueva cita
    @PostMapping
    public ResponseEntity<Citas> crearCita(@RequestBody Citas citas) {
        Citas nuevaCita = citasService.saveCita(citas);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCita);
    }

    // PUT: Actualizar cita existente
    @PutMapping("/{id_cita}")
    public ResponseEntity<Citas> actualizarCita(
            @PathVariable Long id_cita,
            @RequestBody Citas citaActualizada) {

        Optional<Citas> cita = citasService.actualizarCita(id_cita, citaActualizada);
        return cita.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE: Eliminar cita
    @DeleteMapping("/{id_cita}")
    public ResponseEntity<Void> eliminarCita(@PathVariable Long id_cita) {
        if (citasService.deleteCita(id_cita)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // GET: Buscar cita por estado
    @GetMapping("/buscar/estado")
    public ResponseEntity<List<Citas>> buscarPorEstado(@RequestParam("estado") String estado) {
        return citasService.findByEstado(estado)
                .map(c -> ResponseEntity.ok(List.of(c)))
                .orElse(ResponseEntity.notFound().build());
    }

    // GET: Buscar cita por fecha y hora
    @GetMapping("/buscar/fecha-hora")
    public ResponseEntity<Citas> buscarPorFechaHora(@RequestParam("fechaHora") String fechaHora) {
        return citasService.findByFechaHora(fechaHora)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}