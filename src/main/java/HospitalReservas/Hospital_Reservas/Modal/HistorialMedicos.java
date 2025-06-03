package HospitalReservas.Hospital_Reservas.Modal;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
//
public class HistorialMedicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistorial;

    private String diagnostico;
    private String prescripcion;
    private String fechaRegistro;
    private String progreso;

    
    @ManyToOne
    @JoinColumn(name = "id_medico", nullable = false)  
    private Medicos medico;

    
    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false) 
    private Pacientes paciente;
}
