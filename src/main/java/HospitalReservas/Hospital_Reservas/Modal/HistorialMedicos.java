package HospitalReservas.Hospital_Reservas.Modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "historial_medicos")
public class HistorialMedicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistorial;

    private String diagnostico;
    private String prescripcion;
    private String fechaRegistro;
    private String progreso;

    // Relación con Medico (un medico puede tener muchos historiales médicos)
    @ManyToOne
    @JoinColumn(name = "id_medico", nullable = false)  // Clave foránea a Medicos
    private Medicos medico;

    // Relación con Paciente (un paciente puede tener muchos historiales médicos)
    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)  // Clave foránea a Pacientes
    private Pacientes paciente;
}
