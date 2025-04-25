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
@Table(name = "citas")
public class Citas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCita;

    private String fechaHora;
    private String motivo;
    private String estado;
    private String observaciones;

    // Relación con Usuario (un usuario puede tener muchas citas)
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)  // Clave foránea en la tabla Citas
    private Usuarios usuario;

    // Relación con HorariosDisponibles (un horario puede estar asociado a muchas citas)
    @ManyToOne
    @JoinColumn(name = "id_horario", nullable = false)  // Clave foránea en la tabla Citas
    private HorarioDisponibles horario;

    // Relación con Medicos (un medico puede estar asociado a muchas citas)
    @ManyToOne
    @JoinColumn(name = "id_medico", nullable = false)  // Clave foránea en la tabla Citas
    private Medicos medico;

    // Relación con Pacientes (un paciente puede tener muchas citas)
    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)  // Clave foránea en la tabla Citas
    private Pacientes paciente; // Relación con la clase Pacientes
    
    // Relación con ServiciosMedicos (un servicio médico puede estar asociado a muchas citas)
    @ManyToOne
    @JoinColumn(name = "id_servicio", nullable = false)  // Clave foránea en la tabla Citas
    private ServiciosMedicos servicioMedico; // Relación con la clase ServiciosMedicos
}
