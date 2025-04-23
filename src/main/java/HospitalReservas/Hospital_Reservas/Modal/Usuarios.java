package HospitalReservas.Hospital_Reservas.Modal;

import java.time.LocalDateTime;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Table (name = "usuarios")  
public class Usuarios {
//MediFast

    private Long id_usuario;
    private String nombre_usuario;
    private String contraseña;
    private String correo_electronico;
    // falta meter el rol solo tendra la funcion del admin y el medico mas adelante se implementara
    //rol
    private LocalDateTime ultimo_inico_sesion;


}

