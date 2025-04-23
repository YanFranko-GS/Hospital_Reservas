package HospitalReservas.Hospital_Reservas.Modal;

import java.time.LocalDate;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "horarios_disponibles")
public class Horarios_Disponibles {
    
    private Long id_horario_disponible;

    //corregir esto tambien ojo que todo teienq que estar conectado
    private Long id_medico;

    private LocalDate fecha_disponible;
    private String hora_inicio;
    private String hora_fin;
    private String estado;
}
