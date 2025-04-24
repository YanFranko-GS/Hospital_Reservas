package HospitalReservas.Hospital_Reservas.Service;

import HospitalReservas.Hospital_Reservas.Modal.Pagos;
import HospitalReservas.Hospital_Reservas.Repository.PagosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagosService {

    @Autowired
    private PagosRepository pagosRepository;

    public Optional<Pagos> findByIdPago(Long idPago) {
        return pagosRepository.findByIdPago(idPago);
    }

    public Optional<Pagos> findByMetodoPago(String metodoPago) {
        return pagosRepository.findByMetodoPago(metodoPago);
    }

    public Pagos savePago(Pagos pagos) {
        return pagosRepository.save(pagos);
    }

    public List<Pagos> listarPagos() {
        return pagosRepository.findAll();
    }

    public Optional<Pagos> actualizarPago(Long idPago, Pagos actualizado) {
        return pagosRepository.findById(idPago).map(p -> {
            p.setMontoTotal(actualizado.getMontoTotal());
            p.setMetodoPago(actualizado.getMetodoPago());
            p.setFechaPago(actualizado.getFechaPago());
            p.setEstadoPago(actualizado.getEstadoPago());
            return pagosRepository.save(p);
        });
    }

    public boolean deletePago(Long idPago) {
        if (pagosRepository.existsById(idPago)) {
            pagosRepository.deleteById(idPago);
            return true;
        }
        return false;
    }
}