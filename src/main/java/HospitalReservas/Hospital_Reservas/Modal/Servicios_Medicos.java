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

@Table(name = "servicios_medicos")
public class Servicios_Medicos {
    
    private Long id_servicio;
    private String nombre_servicio;
    private double precio;
    private int duracion; // en minutos
    private String descripcion;
    private String estado;
}
