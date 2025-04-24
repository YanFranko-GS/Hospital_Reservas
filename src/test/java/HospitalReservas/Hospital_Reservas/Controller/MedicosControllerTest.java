package HospitalReservas.Hospital_Reservas.Controller;

import HospitalReservas.Hospital_Reservas.Modal.Medicos;
import HospitalReservas.Hospital_Reservas.Service.MedicosService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MedicosControllerTest {

    @Mock
    private MedicosService medicosService;

    @InjectMocks
    private MedicosController medicosController;

    @Test
    void testListarMedicos() {
        List<Medicos> medicos = List.of(new Medicos(), new Medicos());
        when(medicosService.listarMedicos()).thenReturn(medicos);

        ResponseEntity<List<Medicos>> respuesta = medicosController.listarMedicos();

        assertEquals(200, respuesta.getStatusCodeValue());
        assertEquals(2, respuesta.getBody().size());
    }

    @Test
    void testObtenerMedicoPorId_Existente() {
        Long idMedico = 1L;
        Medicos medico = new Medicos();
        when(medicosService.findByIdMedico(idMedico)).thenReturn(Optional.of(medico));

        ResponseEntity<Medicos> respuesta = medicosController.obtenerMedicoPorId(idMedico);

        assertEquals(200, respuesta.getStatusCodeValue());
        assertNotNull(respuesta.getBody());
    }

    @Test
    void testObtenerMedicoPorId_NoExistente() {
        Long idMedico = 2L;
        when(medicosService.findByIdMedico(idMedico)).thenReturn(Optional.empty());

        ResponseEntity<Medicos> respuesta = medicosController.obtenerMedicoPorId(idMedico);

        assertEquals(404, respuesta.getStatusCodeValue());
    }

    @Test
    void testCrearMedico() {
        Medicos nuevoMedico = new Medicos();
        when(medicosService.saveMedico(nuevoMedico)).thenReturn(nuevoMedico);

        ResponseEntity<Medicos> respuesta = medicosController.crearMedico(nuevoMedico);

        assertEquals(201, respuesta.getStatusCodeValue());
        assertNotNull(respuesta.getBody());
    }

    @Test
    void testActualizarMedico_Existente() {
        Long idMedico = 1L;
        Medicos medicoActualizado = new Medicos();
        when(medicosService.actualizarMedico(idMedico, medicoActualizado)).thenReturn(Optional.of(medicoActualizado));

        ResponseEntity<Medicos> respuesta = medicosController.actualizarMedico(idMedico, medicoActualizado);

        assertEquals(200, respuesta.getStatusCodeValue());
        assertNotNull(respuesta.getBody());
    }

    @Test
    void testActualizarMedico_NoExistente() {
        Long idMedico = 2L;
        Medicos medicoActualizado = new Medicos();
        when(medicosService.actualizarMedico(idMedico, medicoActualizado)).thenReturn(Optional.empty());

        ResponseEntity<Medicos> respuesta = medicosController.actualizarMedico(idMedico, medicoActualizado);

        assertEquals(404, respuesta.getStatusCodeValue());
    }

    @Test
    void testEliminarMedico_Existente() {
        Long idMedico = 1L;
        when(medicosService.deleteMedico(idMedico)).thenReturn(true);

        ResponseEntity<Void> respuesta = medicosController.eliminarMedico(idMedico);

        assertEquals(204, respuesta.getStatusCodeValue());
    }

    @Test
    void testEliminarMedico_NoExistente() {
        Long idMedico = 2L;
        when(medicosService.deleteMedico(idMedico)).thenReturn(false);

        ResponseEntity<Void> respuesta = medicosController.eliminarMedico(idMedico);

        assertEquals(404, respuesta.getStatusCodeValue());
    }
}