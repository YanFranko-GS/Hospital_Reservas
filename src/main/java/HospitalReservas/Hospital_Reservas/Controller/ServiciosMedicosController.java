package HospitalReservas.Hospital_Reservas.Controller;

import HospitalReservas.Hospital_Reservas.Modal.ServiciosMedicos;
import HospitalReservas.Hospital_Reservas.Service.ServiciosMedicosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/servicios-medicos")
public class ServiciosMedicosController {

    @Autowired
    private ServiciosMedicosService serviciosMedicosService;

    // GET: Listar todos los servicios médicos
    @GetMapping
    public ResponseEntity<List<ServiciosMedicos>> listarServiciosMedicos() {
        return ResponseEntity.ok(serviciosMedicosService.listarServiciosMedicos());
    }

    // GET: Buscar servicio médico por ID
    @GetMapping("/{id_servicio}")
    public ResponseEntity<ServiciosMedicos> obtenerServicioPorId(@PathVariable("id_servicio") Long idServicio) {
        Optional<ServiciosMedicos> servicio = serviciosMedicosService.findByIdServicio(idServicio);
        return servicio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST: Crear nuevo servicio médico
    @PostMapping
    public ResponseEntity<ServiciosMedicos> crearServicioMedico(@RequestBody ServiciosMedicos serviciosMedicos) {
        ServiciosMedicos nuevoServicio = serviciosMedicosService.saveServicioMedico(serviciosMedicos);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoServicio);
    }

    // PUT: Actualizar servicio médico existente
    @PutMapping("/{id_servicio}")
    public ResponseEntity<ServiciosMedicos> actualizarServicioMedico(
            @PathVariable Long id_servicio,
            @RequestBody ServiciosMedicos servicioActualizado) {

        Optional<ServiciosMedicos> servicio = serviciosMedicosService.actualizarServicioMedico(id_servicio, servicioActualizado);
        return servicio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE: Eliminar servicio médico
    @DeleteMapping("/{id_servicio}")
    public ResponseEntity<Void> eliminarServicioMedico(@PathVariable Long id_servicio) {
        if (serviciosMedicosService.deleteServicioMedico(id_servicio)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}