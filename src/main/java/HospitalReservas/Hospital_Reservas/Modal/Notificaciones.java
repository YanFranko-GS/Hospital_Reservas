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
@Table(name = "notificaciones")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idNotificacion")
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
