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
@Table(name = "medicos")
public class Medicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedico;

    private String nombreCompleto;
    private String especialidad;
    private String numeroColegiado;
    private String horarioLaboral;
    private String consultorio;
    private String telefono;
    private String correoElectronico;

    // Relación con Citas (un medico puede tener muchas citas)
    @OneToMany(mappedBy = "medico")
    private List<Citas> citas;  // Relación inversa con Citas
}
