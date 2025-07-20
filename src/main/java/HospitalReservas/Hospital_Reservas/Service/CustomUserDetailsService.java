package HospitalReservas.Hospital_Reservas.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//import HospitalReservas.Hospital_Reservas.Modal.Usuarios;
import HospitalReservas.Hospital_Reservas.Repository.UsuariosRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuariosRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String nombreOrCorreo) throws UsernameNotFoundException {
        return usuarioRepository.findByNombreUsuarioOrCorreoElectronico(nombreOrCorreo, nombreOrCorreo)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "Usuario no encontrado con username o email: " + nombreOrCorreo));
    }
}