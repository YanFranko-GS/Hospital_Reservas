package HospitalReservas.Hospital_Reservas.Service;

import HospitalReservas.Hospital_Reservas.Modal.HistorialMedicos;
import HospitalReservas.Hospital_Reservas.Repository.HistorialMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialMedicoService {

    @Autowired
    private HistorialMedicoRepository historialMedicoRepository;

    public Optional<HistorialMedicos> findByIdHistorial(Long idHistorial) {
        return historialMedicoRepository.findByIdHistorial(idHistorial);
    }

    public Optional<HistorialMedicos> findByDiagnostico(String diagnostico) {
        return historialMedicoRepository.findByDiagnostico(diagnostico);
    }

    public HistorialMedicos saveHistorialMedico(HistorialMedicos historialMedicos) {
        return historialMedicoRepository.save(historialMedicos);
    }

    public List<HistorialMedicos> listarHistorialesMedicos() {
        return historialMedicoRepository.findAll();
    }

    public Optional<HistorialMedicos> actualizarHistorialMedico(Long idHistorial, HistorialMedicos actualizado) {
        return historialMedicoRepository.findById(idHistorial).map(h -> {
            h.setDiagnostico(actualizado.getDiagnostico());
            h.setPrescripcion(actualizado.getPrescripcion());
            h.setFechaRegistro(actualizado.getFechaRegistro());
            h.setProgreso(actualizado.getProgreso());
            return historialMedicoRepository.save(h);
        });
    }

    public boolean deleteHistorialMedico(Long idHistorial) {
        if (historialMedicoRepository.existsById(idHistorial)) {
            historialMedicoRepository.deleteById(idHistorial);
            return true;
        }
        return false;
    }
}