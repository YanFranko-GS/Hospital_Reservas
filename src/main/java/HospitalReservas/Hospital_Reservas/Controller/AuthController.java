package HospitalReservas.Hospital_Reservas.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HospitalReservas.Hospital_Reservas.DTO.JwtAuthResponse;
import HospitalReservas.Hospital_Reservas.DTO.LoginDTO;
import HospitalReservas.Hospital_Reservas.DTO.RegistroDTO;
import HospitalReservas.Hospital_Reservas.Service.AuthService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        String token = authService.login(loginDTO);

        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setToken(token);

        return ResponseEntity.ok(jwtAuthResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registrar(@RequestBody RegistroDTO registroDTO) {
        String respuesta = authService.registrar(registroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }
}
