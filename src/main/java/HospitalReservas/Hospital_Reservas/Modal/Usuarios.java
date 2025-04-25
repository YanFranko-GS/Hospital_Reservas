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
@Table(name = "usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String nombreUsuario;
    private String contraseña;
    private String correoElectronico;
    private String rol;
    private String ultimoInicioSesion;

    // Relación con Notificaciones (un usuario puede tener muchas notificaciones)
    @OneToMany(mappedBy = "usuario")
    private List<Notificaciones> notificaciones;  // Relación inversa con Notificaciones

    // Relación con Pagos (un usuario puede tener muchos pagos)
    @OneToMany(mappedBy = "usuario")
    private List<Pagos> pagos;  // Relación inversa con Pagos
}
