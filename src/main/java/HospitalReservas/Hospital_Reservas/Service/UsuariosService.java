package HospitalReservas.Hospital_Reservas.Service;

import HospitalReservas.Hospital_Reservas.Modal.Usuarios;
import HospitalReservas.Hospital_Reservas.Repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    public Optional<Usuarios> findByIdUsuario(Long idUsuario) {
        return usuariosRepository.findByIdUsuario(idUsuario);
    }

    public Optional<Usuarios> findByNombreUsuario(String nombreUsuario) {
        return usuariosRepository.findByNombreUsuario(nombreUsuario);
    }

    public Optional<Usuarios> findByCorreoElectronico(String correoElectronico) {
        return usuariosRepository.findByCorreoElectronico(correoElectronico);
    }

    public Usuarios saveUsuario(Usuarios usuarios) {
        return usuariosRepository.save(usuarios);
    }

    public List<Usuarios> listarUsuarios() {
        return usuariosRepository.findAll();
    }

    public Optional<Usuarios> actualizarUsuario(Long idUsuario, Usuarios actualizado) {
        return usuariosRepository.findById(idUsuario).map(u -> {
            u.setNombreUsuario(actualizado.getNombreUsuario());
            u.setContraseña(actualizado.getContraseña());
            u.setCorreoElectronico(actualizado.getCorreoElectronico());
            u.setRol(actualizado.getRol());
            return usuariosRepository.save(u);
        });
    }

    public boolean deleteUsuario(Long idUsuario) {
        if (usuariosRepository.existsById(idUsuario)) {
            usuariosRepository.deleteById(idUsuario);
            return true;
        }
        return false;
    }
}