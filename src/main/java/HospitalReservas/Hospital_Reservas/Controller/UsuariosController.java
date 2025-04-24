package HospitalReservas.Hospital_Reservas.Controller;

import HospitalReservas.Hospital_Reservas.Modal.Usuarios;
import HospitalReservas.Hospital_Reservas.Service.UsuariosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping
    public ResponseEntity<List<Usuarios>> listarUsuarios() {
        return ResponseEntity.ok(usuariosService.listarUsuarios());
    }

    @GetMapping("/{id_usuario}")
    public ResponseEntity<Usuarios> obtenerUsuarioPorId(@PathVariable("id_usuario") Long idUsuario) {
        Optional<Usuarios> usuario = usuariosService.findByIdUsuario(idUsuario);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usuarios> crearUsuario(@RequestBody Usuarios usuarios) {
        Usuarios nuevoUsuario = usuariosService.saveUsuario(usuarios);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }

    @PutMapping("/{id_usuario}")
    public ResponseEntity<Usuarios> actualizarUsuario(@PathVariable Long id_usuario, @RequestBody Usuarios usuarioActualizado) {
        Optional<Usuarios> usuario = usuariosService.actualizarUsuario(id_usuario, usuarioActualizado);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id_usuario}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id_usuario) {
        if (usuariosService.deleteUsuario(id_usuario)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}