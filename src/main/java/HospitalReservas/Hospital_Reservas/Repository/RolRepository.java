package HospitalReservas.Hospital_Reservas.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import HospitalReservas.Hospital_Reservas.Modal.ERol;
import HospitalReservas.Hospital_Reservas.Modal.Rol;



@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByNombre(ERol nombre);
}