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
@Table(name = "servicios_medicos")
public class ServiciosMedicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idServicio;

    private String nombreServicio;
    private double precio;
    private int duracion;
    private String descripcion;
    private String estado;

    // Relación con HorariosDisponibles (un servicio puede estar disponible en varios horarios)
    @OneToMany(mappedBy = "servicioMedico")
    private List<HorarioDisponibles> horariosDisponibles;  // Relación inversa con HorariosDisponibles

    // Relación con Citas (un servicio puede estar asociado a varias citas)
    @OneToMany(mappedBy = "servicioMedico")
    private List<Citas> citas;  // Relación inversa con Citas
}
