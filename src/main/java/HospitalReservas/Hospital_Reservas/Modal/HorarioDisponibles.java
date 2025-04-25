package HospitalReservas.Hospital_Reservas.Modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "horarios_disponibles")
public class HorarioDisponibles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHorario;

    private String fechaDisponibilidad;
    private String horaInicio;
    private String horaFin;
    private String estado;

    // Relación con ServiciosMedicos (un servicio médico puede estar disponible en varios horarios)
    @ManyToOne
    @JoinColumn(name = "id_servicio", nullable = false)  // Clave foránea a ServiciosMedicos
    private ServiciosMedicos servicioMedico;

    // Relación con Citas (un horario puede estar asociado a muchas citas)
    @OneToMany(mappedBy = "horario")
    private List<Citas> citas;  // Relación inversa con Citas
}
