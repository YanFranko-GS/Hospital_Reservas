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

@Table(name = "historial_medico")
public class Historial_Medico {

    private Long id_historial;
    
    //no olvidas lo mismo como lo demas CORREGIR
    private Long id_paciente;

    private String diagnostico;
    private String prescripcion;
    private LocalDate fecha_registro;
    private String progreso;
}
