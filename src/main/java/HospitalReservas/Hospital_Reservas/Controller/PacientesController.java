package HospitalReservas.Hospital_Reservas.Controller;

import HospitalReservas.Hospital_Reservas.Modal.Pacientes;
import HospitalReservas.Hospital_Reservas.Service.PacientesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pacientes")
public class PacientesController {
    @Autowired
    private PacientesService pacientesService;

   
    
    @GetMapping
    public ResponseEntity<List<Pacientes>> listarPacientes() {
        return ResponseEntity.ok(pacientesService.listarPacientes());
    }

    
    @GetMapping("/{id_paciente}")
    public ResponseEntity<Pacientes> obtenerPacientesPorId(@PathVariable("id_paciente") Long idPaciente) {
        Optional<Pacientes> paciente = pacientesService.obtenerPacientesPorId(idPaciente);
        return paciente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

   

    @PostMapping
    public ResponseEntity<Pacientes> crearPacientes(@RequestBody Pacientes paciente) {
        Pacientes nuevoPaciente = pacientesService.savePacientes(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPaciente);
    }
    
    @PutMapping("/{id_paciente}")
    public ResponseEntity<Pacientes> actualizarPacientes(
            @PathVariable Long id_paciente,
            @RequestBody Pacientes pacienteActualizado) {

        Optional<Pacientes> paciente = pacientesService.actualizarPacientes(id_paciente, pacienteActualizado);
        return paciente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

   
    @DeleteMapping("/{id_paciente}")
    public ResponseEntity<Void> eliminarPacientes(@PathVariable Long id_paciente) {
        if (pacientesService.deletePacientes(id_paciente)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
    @GetMapping("/buscar/correo")
    public ResponseEntity<Pacientes> buscarPorCorreo(@RequestParam("correo") String correo) {
        return pacientesService.findByCorreoElectronico(correo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    
    @GetMapping("/buscar/telefono")
    public ResponseEntity<Pacientes> buscarPorTelefono(@RequestParam("telefono") int telefono) {
        return pacientesService.findByTelefono(telefono)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

   
    @GetMapping("/buscar/documento")
    public ResponseEntity<Pacientes> buscarPorDocumento(@RequestParam("documento") String numeroDocumento) {
        return pacientesService.findByNumeroDocumento(numeroDocumento)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
