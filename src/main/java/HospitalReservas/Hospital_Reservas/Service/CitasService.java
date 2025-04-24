package HospitalReservas.Hospital_Reservas.Service;

import HospitalReservas.Hospital_Reservas.Modal.Citas;
import HospitalReservas.Hospital_Reservas.Repository.CitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitasService {

    @Autowired
    private CitasRepository citasRepository;

    public Optional<Citas> findByIdCita(Long idCita) {
        return citasRepository.findByIdCita(idCita);
    }

    public Optional<Citas> findByFechaHora(String fechaHora) {
        return citasRepository.findByFechaHora(fechaHora);
    }

    public Optional<Citas> findByEstado(String estado) {
        return citasRepository.findByEstado(estado);
    }

    public Citas saveCita(Citas citas) {
        return citasRepository.save(citas);
    }

    public List<Citas> listarCitas() {
        return citasRepository.findAll();
    }

    public Optional<Citas> actualizarCita(Long idCita, Citas actualizado) {
        return citasRepository.findById(idCita).map(c -> {
            c.setFechaHora(actualizado.getFechaHora());
            c.setMotivo(actualizado.getMotivo());
            c.setEstado(actualizado.getEstado());
            c.setObservaciones(actualizado.getObservaciones());
            return citasRepository.save(c);
        });
    }

    public boolean deleteCita(Long idCita) {
        if (citasRepository.existsById(idCita)) {
            citasRepository.deleteById(idCita);
            return true;
        }
        return false;
    }
}