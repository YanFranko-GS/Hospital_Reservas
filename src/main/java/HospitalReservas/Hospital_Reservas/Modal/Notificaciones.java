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
@Table(name = "notificaciones")
public class Notificaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNotificacion;

    private String tipoNotificacion;
    private String fechaEnvio;
    private String medioEnvio;
    private String mensaje;

    // Relación con Usuario (una notificación pertenece a un único usuario)
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)  // Clave foránea a Usuarios
    private Usuarios usuario;
}
