package HospitalReservas.Hospital_Reservas.Controller;

import HospitalReservas.Hospital_Reservas.Modal.HorarioDisponibles;
import HospitalReservas.Hospital_Reservas.Service.HorarioDisponiblesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/horarios")

public class HorarioDisponiblesController {

    @Autowired
    private HorarioDisponiblesService horarioDisponiblesService;

  
    @GetMapping
    public ResponseEntity<List<HorarioDisponibles>> listarHorariosDisponibles() {
        return ResponseEntity.ok(horarioDisponiblesService.listarHorarioDisponibles());
    }

  
    @GetMapping("/{id_horario}")
    public ResponseEntity<HorarioDisponibles> obtenerHorarioPorId(@PathVariable("id_horario") Long idHorario) {
        Optional<HorarioDisponibles> horario = horarioDisponiblesService.findByIdHorario(idHorario);
        return horario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

 
    @PostMapping
    public ResponseEntity<HorarioDisponibles> crearHorarioDisponible(@RequestBody HorarioDisponibles horario) {
        HorarioDisponibles nuevoHorario = horarioDisponiblesService.saveHorarioDisponible(horario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoHorario);
    }

    
    @PutMapping("/{id_horario}")
    public ResponseEntity<HorarioDisponibles> actualizarHorarioDisponible(
            @PathVariable Long id_horario,
            @RequestBody HorarioDisponibles horarioActualizado) {

        Optional<HorarioDisponibles> horario = horarioDisponiblesService.actualizarHorario(id_horario, horarioActualizado);
        return horario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

  
    @DeleteMapping("/{id_horario}")
    public ResponseEntity<Void> eliminarHorarioDisponible(@PathVariable Long id_horario) {
        if (horarioDisponiblesService.deleteHorarioDisponible(id_horario)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/buscar/fecha")
    public ResponseEntity<List<HorarioDisponibles>> buscarPorFecha(@RequestParam("fecha") String fechaDisponibilidad) {
        return horarioDisponiblesService.findByFechaDisponibilidad(fechaDisponibilidad)
                .map(h -> ResponseEntity.ok(List.of(h)))
                .orElse(ResponseEntity.notFound().build());
    }
}