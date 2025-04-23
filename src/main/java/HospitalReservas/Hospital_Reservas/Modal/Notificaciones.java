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

@Table(name = "notificaciones")
public class Notificaciones {
    
    private Long id_notificacion;
    
    //corregir no olvidar 
    private Long id_cita;

    private String tipo_notificacion;
    private LocalDateTime fecha_envio;
    private String medio_envio;
    private String mensaje;
}
