package HospitalReservas.Hospital_Reservas.Controller;

import HospitalReservas.Hospital_Reservas.Modal.Pacientes;
import HospitalReservas.Hospital_Reservas.Service.PacientesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PacientesControllerTest {

    @Mock
    private PacientesService pacientesService;

    @InjectMocks
    private PacientesController pacientesController;

    @Test
    void testListarPacientes() {
        List<Pacientes> pacientes = List.of(new Pacientes(), new Pacientes());
        when(pacientesService.listarPacientes()).thenReturn(pacientes);

        ResponseEntity<List<Pacientes>> respuesta = pacientesController.listarPacientes();
        
        assertEquals(200, respuesta.getStatusCodeValue());
        assertEquals(2, respuesta.getBody().size());
    }

    @Test
    void testObtenerPacientePorId_Existente() {
        Long idPaciente = 1L;
        Pacientes paciente = new Pacientes();
        when(pacientesService.obtenerPacientesPorId(idPaciente)).thenReturn(Optional.of(paciente));

        ResponseEntity<Pacientes> respuesta = pacientesController.obtenerPacientesPorId(idPaciente);
        
        assertEquals(200, respuesta.getStatusCodeValue());
        assertNotNull(respuesta.getBody());
    }

    @Test
    void testObtenerPacientePorId_NoExistente() {
        Long idPaciente = 2L;
        when(pacientesService.obtenerPacientesPorId(idPaciente)).thenReturn(Optional.empty());

        ResponseEntity<Pacientes> respuesta = pacientesController.obtenerPacientesPorId(idPaciente);
        
        assertEquals(404, respuesta.getStatusCodeValue());
    }

    @Test
    void testCrearPaciente() {
        Pacientes nuevoPaciente = new Pacientes();
        when(pacientesService.savePacientes(nuevoPaciente)).thenReturn(nuevoPaciente);

        ResponseEntity<Pacientes> respuesta = pacientesController.crearPacientes(nuevoPaciente);
        
        assertEquals(201, respuesta.getStatusCodeValue());
        assertNotNull(respuesta.getBody());
    }

    @Test
    void testEliminarPaciente_Existente() {
        Long idPaciente = 1L;
        when(pacientesService.deletePacientes(idPaciente)).thenReturn(true);

        ResponseEntity<Void> respuesta = pacientesController.eliminarPacientes(idPaciente);
        
        assertEquals(204, respuesta.getStatusCodeValue());
    }

    @Test
    void testEliminarPaciente_NoExistente() {
        Long idPaciente = 2L;
        when(pacientesService.deletePacientes(idPaciente)).thenReturn(false);

        ResponseEntity<Void> respuesta = pacientesController.eliminarPacientes(idPaciente);
        
        assertEquals(404, respuesta.getStatusCodeValue());
    }
}