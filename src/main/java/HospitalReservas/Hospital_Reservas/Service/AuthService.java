package HospitalReservas.Hospital_Reservas.Service;

import HospitalReservas.Hospital_Reservas.DTO.LoginDTO;
import HospitalReservas.Hospital_Reservas.DTO.RegistroDTO;

public interface AuthService {
    String login(LoginDTO loginDTO);
    String registrar(RegistroDTO registroDTO);
}
