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

@Table(name = "citas")
public class Citas {

    
    private Long id_cita;

    //esto tiene que jalar el id del paciente , medico y el servicio "Falta especificar Corregir esto"
    //No olvidar
    private Long id_paciente;
    private Long id_medico;
    //  

    private LocalDateTime fecha_hora;
    private String motivo;
    
    //esto tiene que ir en una lista en donde el estado de la cita esta en proceso o en espera "arreglar mas tarde"
    //No olvidar 
    private String estado =("Pendiente, Confirmada, Cancelada, Completada"); 
    private String observaciones;

    //esto tiene que jalar el id del servicio "Falta especificar Corregir esto"
    private Long id_servicio;
}
