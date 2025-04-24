package HospitalReservas.Hospital_Reservas.Controller;

import HospitalReservas.Hospital_Reservas.Modal.Medicos;
import HospitalReservas.Hospital_Reservas.Service.MedicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medicos")
public class MedicosController {

    @Autowired
    private MedicosService medicosService;

    @GetMapping
    public ResponseEntity<List<Medicos>> listarMedicos() {
        return ResponseEntity.ok(medicosService.listarMedicos());
    }

    @GetMapping("/{id_medico}")
    public ResponseEntity<Medicos> obtenerMedicoPorId(@PathVariable("id_medico") Long idMedico) {
        Optional<Medicos> medico = medicosService.findByIdMedico(idMedico);
        return medico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Medicos> crearMedico(@RequestBody Medicos medicos) {
        Medicos nuevoMedico = medicosService.saveMedico(medicos);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoMedico);
    }

    @PutMapping("/{id_medico}")
    public ResponseEntity<Medicos> actualizarMedico(@PathVariable Long id_medico, @RequestBody Medicos medicoActualizado) {
        Optional<Medicos> medico = medicosService.actualizarMedico(id_medico, medicoActualizado);
        return medico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id_medico}")
    public ResponseEntity<Void> eliminarMedico(@PathVariable Long id_medico) {
        if (medicosService.deleteMedico(id_medico)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}