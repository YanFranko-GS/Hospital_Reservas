package HospitalReservas.Hospital_Reservas.Service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import HospitalReservas.Hospital_Reservas.Config.JwtTokenProvider;
import HospitalReservas.Hospital_Reservas.DTO.LoginDTO;
import HospitalReservas.Hospital_Reservas.DTO.RegistroDTO;
import HospitalReservas.Hospital_Reservas.Modal.ERol;
import HospitalReservas.Hospital_Reservas.Modal.Rol;
import HospitalReservas.Hospital_Reservas.Modal.Usuarios;
import HospitalReservas.Hospital_Reservas.Repository.RolRepository;
import HospitalReservas.Hospital_Reservas.Repository.UsuariosRepository;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    
    private final AuthenticationManager authenticationManager;
    private final UsuariosRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public String login(LoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginDTO.getNombreOrCorreo(),
                loginDTO.getContrasena()
            )
        );
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        return jwtTokenProvider.generateToken((UserDetails) authentication.getPrincipal());
    }

    @Override
    public String registrar(RegistroDTO registroDTO) {
        if (usuarioRepository.existsByNombreUsuario(registroDTO.getNombreUsuario())) {
            throw new RuntimeException("El nombre de usuario ya existe");
        }
        
        if (usuarioRepository.existsByCorreoElectronico(registroDTO.getCorreoElectronico())) {
            throw new RuntimeException("El email ya está en uso");
        }
        
        Usuarios usuario = new Usuarios();
        usuario.setNombreUsuario(registroDTO.getNombreUsuario());
        usuario.setCorreoElectronico(registroDTO.getCorreoElectronico());
        usuario.setContrasena(passwordEncoder.encode(registroDTO.getContrasena()));
        
        Rol rol = rolRepository.findByNombre(ERol.ROLE_USER)
            .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        
        usuario.getRoles().add(rol);
        usuarioRepository.save(usuario);
        
        return "Usuario registrado exitosamente";
    }
}
