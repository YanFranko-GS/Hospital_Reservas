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

@Table(name = "pagos")
public class Pagos {
    
    private Long id_pago;
    //nO OLVIDAR CORREGIR ESTO TAMBIEN MAS ADELANTE
    private Long id_cita;

    private double monto_total;
    private String metodo_pago;
    private String fecha_pago;
    private String estado_pago;

}
