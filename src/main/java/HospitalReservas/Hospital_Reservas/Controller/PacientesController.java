package HospitalReservas.Hospital_Reservas.Controller;

import HospitalReservas.Hospital_Reservas.Service.PacientesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import HospitalReservas.Hospital_Reservas.Modal.Pacientes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/pacientes")
public class PacientesController {

    private PacientesService pacientesService;

    // Lista los pacientes
    @GetMapping()
    public ResponseEntity<List<Pacientes>> listarPacientes() {
        return ResponseEntity.ok(pacientesService.listarPacientes());
    }

    // Busca paciente por ID
    @GetMapping("/{id_paciente}")
    public ResponseEntity<Pacientes> obtenerPacientesPorId(@PathVariable("id_paciente") Long idPaciente) {
        Optional<Pacientes> paciente = pacientesService.obtenerPacientesPorId(idPaciente);
        return paciente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crea un nuevo paciente
    @PostMapping()
    public ResponseEntity<Pacientes> crearPacientes(@RequestBody Pacientes paciente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pacientesService.savePacientes(paciente));
    }

    // Actualiza un paciente existente
    @PutMapping("/{id_paciente}")
    public ResponseEntity<Pacientes> actualizarPacientes(@PathVariable Long id_paciente,
            @RequestBody Pacientes pacienteActualizado) {
        Optional<Pacientes> paciente = pacientesService.actualizarPacientes(id_paciente, pacienteActualizado);
        return paciente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // elimina ps
    @DeleteMapping("/{id_paciente}")
    public ResponseEntity<Void> eliminarPacientes(@PathVariable Long id_paciente) {
        if (pacientesService.eliminarPacientes(id_paciente)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
