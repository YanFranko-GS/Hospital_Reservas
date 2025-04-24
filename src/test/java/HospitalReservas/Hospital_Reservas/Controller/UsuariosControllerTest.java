package HospitalReservas.Hospital_Reservas.Controller;

import HospitalReservas.Hospital_Reservas.Modal.Usuarios;
import HospitalReservas.Hospital_Reservas.Service.UsuariosService;
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
public class UsuariosControllerTest {

    @Mock
    private UsuariosService usuariosService;

    @InjectMocks
    private UsuariosController usuariosController;

    @Test
    void testListarUsuarios() {
        List<Usuarios> usuarios = List.of(new Usuarios(), new Usuarios());
        when(usuariosService.listarUsuarios()).thenReturn(usuarios);

        ResponseEntity<List<Usuarios>> respuesta = usuariosController.listarUsuarios();

        assertEquals(200, respuesta.getStatusCodeValue());
        assertEquals(2, respuesta.getBody().size());
    }

    @Test
    void testObtenerUsuarioPorId_Existente() {
        Long idUsuario = 1L;
        Usuarios usuario = new Usuarios();
        when(usuariosService.findByIdUsuario(idUsuario)).thenReturn(Optional.of(usuario));

        ResponseEntity<Usuarios> respuesta = usuariosController.obtenerUsuarioPorId(idUsuario);

        assertEquals(200, respuesta.getStatusCodeValue());
        assertNotNull(respuesta.getBody());
    }

    @Test
    void testObtenerUsuarioPorId_NoExistente() {
        Long idUsuario = 2L;
        when(usuariosService.findByIdUsuario(idUsuario)).thenReturn(Optional.empty());

        ResponseEntity<Usuarios> respuesta = usuariosController.obtenerUsuarioPorId(idUsuario);

        assertEquals(404, respuesta.getStatusCodeValue());
    }

    @Test
    void testCrearUsuario() {
        Usuarios nuevoUsuario = new Usuarios();
        when(usuariosService.saveUsuario(nuevoUsuario)).thenReturn(nuevoUsuario);

        ResponseEntity<Usuarios> respuesta = usuariosController.crearUsuario(nuevoUsuario);

        assertEquals(201, respuesta.getStatusCodeValue());
        assertNotNull(respuesta.getBody());
    }

    @Test
    void testActualizarUsuario_Existente() {
        Long idUsuario = 1L;
        Usuarios usuarioActualizado = new Usuarios();
        when(usuariosService.actualizarUsuario(idUsuario, usuarioActualizado)).thenReturn(Optional.of(usuarioActualizado));

        ResponseEntity<Usuarios> respuesta = usuariosController.actualizarUsuario(idUsuario, usuarioActualizado);

        assertEquals(200, respuesta.getStatusCodeValue());
        assertNotNull(respuesta.getBody());
    }

    @Test
    void testActualizarUsuario_NoExistente() {
        Long idUsuario = 2L;
        Usuarios usuarioActualizado = new Usuarios();
        when(usuariosService.actualizarUsuario(idUsuario, usuarioActualizado)).thenReturn(Optional.empty());

        ResponseEntity<Usuarios> respuesta = usuariosController.actualizarUsuario(idUsuario, usuarioActualizado);

        assertEquals(404, respuesta.getStatusCodeValue());
    }

    @Test
    void testEliminarUsuario_Existente() {
        Long idUsuario = 1L;
        when(usuariosService.deleteUsuario(idUsuario)).thenReturn(true);

        ResponseEntity<Void> respuesta = usuariosController.eliminarUsuario(idUsuario);

        assertEquals(204, respuesta.getStatusCodeValue());
    }

    @Test
    void testEliminarUsuario_NoExistente() {
        Long idUsuario = 2L;
        when(usuariosService.deleteUsuario(idUsuario)).thenReturn(false);

        ResponseEntity<Void> respuesta = usuariosController.eliminarUsuario(idUsuario);

        assertEquals(404, respuesta.getStatusCodeValue());
    }
}