package HospitalReservas.Hospital_Reservas.Repository;

import HospitalReservas.Hospital_Reservas.Modal.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

    Optional<Usuarios> findByIdUsuario(Long idUsuario);
    Optional<Usuarios> findByNombreUsuario(String nombreUsuario);
    Optional<Usuarios> findByCorreoElectronico(String correoElectronico);
}