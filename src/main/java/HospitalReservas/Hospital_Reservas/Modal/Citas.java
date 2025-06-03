package HospitalReservas.Hospital_Reservas.Modal;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "citas")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCita")
public class Citas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCita;

    private String fechaHora;
    private String motivo;
    private String estado;
    private String observaciones;

    

    
    @ManyToOne
    @JoinColumn(name = "id_horario", nullable = false)  
    
    private HorarioDisponibles horario;

    
    @ManyToOne
    @JoinColumn(name = "id_medico", nullable = false)  
    
    private Medicos medico;

   
    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)  
    
    private Pacientes paciente;
    
    
    @ManyToOne
    @JoinColumn(name = "id_servicio", nullable = false) 
    
    private ServiciosMedicos servicioMedico; 
}
