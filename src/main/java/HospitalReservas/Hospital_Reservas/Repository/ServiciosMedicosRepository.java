package HospitalReservas.Hospital_Reservas.Repository;

import HospitalReservas.Hospital_Reservas.Modal.ServiciosMedicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServiciosMedicosRepository extends JpaRepository<ServiciosMedicos, Long> {

    Optional<ServiciosMedicos> findByIdServicio(Long idServicio);
    Optional<ServiciosMedicos> findByNombreServicio(String nombreServicio);
    Optional<ServiciosMedicos> findByEstado(String estado);
}