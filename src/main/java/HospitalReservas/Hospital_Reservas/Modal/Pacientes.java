package HospitalReservas.Hospital_Reservas.Modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor



@Table(name = "pacientes")
@Entity
public class Pacientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_paciente;
    
    private String nombre_completo;
    private String fecha_nacimiento;
    private String correo_electronico;
    private int telefono;
    private String direccion;
    private String sexo;
    private String Tipo_documento;
    private String numero_documento;

    //esto es el id tiene que jalar el historial por el momento no tendra una funcion NO OLVIDAR
    private Long historial_medico;
}

