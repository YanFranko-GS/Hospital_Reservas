package HospitalReservas.Hospital_Reservas.Controller;

import HospitalReservas.Hospital_Reservas.Modal.HistorialMedicos;
import HospitalReservas.Hospital_Reservas.Service.HistorialMedicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/historiales")
public class HistorialMedicoController {

    @Autowired
    private HistorialMedicoService historialMedicoService;

    
    @GetMapping
    public ResponseEntity<List<HistorialMedicos>> listarHistoriales() {
        return ResponseEntity.ok(historialMedicoService.listarHistorialesMedicos());
    }

    
    @GetMapping("/{id_historial}")
    public ResponseEntity<HistorialMedicos> obtenerHistorialPorId(@PathVariable("id_historial") Long idHistorial) {
        Optional<HistorialMedicos> historial = historialMedicoService.findByIdHistorial(idHistorial);
        return historial.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    
    @PostMapping
    public ResponseEntity<HistorialMedicos> crearHistorial(@RequestBody HistorialMedicos historial) {
        HistorialMedicos nuevoHistorial = historialMedicoService.saveHistorialMedico(historial);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoHistorial);
    }

    
    @PutMapping("/{id_historial}")
    public ResponseEntity<HistorialMedicos> actualizarHistorial(
            @PathVariable Long id_historial,
            @RequestBody HistorialMedicos historialActualizado) {

        Optional<HistorialMedicos> historial = historialMedicoService.actualizarHistorialMedico(id_historial, historialActualizado);
        return historial.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    
    @DeleteMapping("/{id_historial}")
    public ResponseEntity<Void> eliminarHistorial(@PathVariable Long id_historial) {
        if (historialMedicoService.deleteHistorialMedico(id_historial)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
    @GetMapping("/buscar/diagnostico")
    public ResponseEntity<List<HistorialMedicos>> buscarPorDiagnostico(@RequestParam("diagnostico") String diagnostico) {
        Optional<HistorialMedicos> historial = historialMedicoService.findByDiagnostico(diagnostico);
        return historial.map(h -> ResponseEntity.ok(List.of(h)))
                .orElse(ResponseEntity.notFound().build());
    }
}