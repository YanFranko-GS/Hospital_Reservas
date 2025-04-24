package HospitalReservas.Hospital_Reservas.Repository;

import HospitalReservas.Hospital_Reservas.Modal.Pagos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PagosRepository extends JpaRepository<Pagos, Long> {

    Optional<Pagos> findByIdPago(Long idPago);
    Optional<Pagos> findByMetodoPago(String metodoPago);
    Optional<Pagos> findByEstadoPago(String estadoPago);
}