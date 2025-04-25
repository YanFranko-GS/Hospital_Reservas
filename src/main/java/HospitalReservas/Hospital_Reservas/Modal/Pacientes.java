package HospitalReservas.Hospital_Reservas.Modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pacientes")
public class Pacientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;

    private String nombreCompleto;
    private String fechaNacimiento;
    private String correoElectronico;
    private int telefono;
    private String direccion;
    private String sexo;
    private String tipoDocumento;
    private String numeroDocumento;

    // Relación con Citas (un paciente puede tener muchas citas)
    @OneToMany(mappedBy = "paciente")
    private List<Citas> citas;  // Relación inversa con Citas
}
