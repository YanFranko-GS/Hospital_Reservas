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
@Table(name = "pagos")
public class Pagos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPago;

    private double montoTotal;
    private String metodoPago;
    private String fechaPago;
    private String estadoPago;

    // Relación con Usuario (un pago pertenece a un único usuario)
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)  // Clave foránea a Usuarios
    private Usuarios usuario;
}
