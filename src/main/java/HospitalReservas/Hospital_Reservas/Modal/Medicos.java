package HospitalReservas.Hospital_Reservas.Modal;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "medicos")
public class Medicos {
    
    private Long id_medico;
    private String nombre_completo;
    private String especialidad;
    private String numero_colegiado;
    private String horario_laboral;
    private String consultario;
    private int telefono;
    private String correo_electronico;
    
}
