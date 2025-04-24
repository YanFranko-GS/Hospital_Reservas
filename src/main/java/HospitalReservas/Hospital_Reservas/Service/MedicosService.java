package HospitalReservas.Hospital_Reservas.Service;

import HospitalReservas.Hospital_Reservas.Modal.Medicos;
import HospitalReservas.Hospital_Reservas.Repository.MedicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicosService {

    @Autowired
    private MedicosRepository medicosRepository;

    public Optional<Medicos> findByIdMedico(Long idMedico) {
        return medicosRepository.findByIdMedico(idMedico);
    }

    public Optional<Medicos> findByEspecialidad(String especialidad) {
        return medicosRepository.findByEspecialidad(especialidad);
    }

    public Medicos saveMedico(Medicos medicos) {
        return medicosRepository.save(medicos);
    }

    public List<Medicos> listarMedicos() {
        return medicosRepository.findAll();
    }

    public Optional<Medicos> actualizarMedico(Long idMedico, Medicos actualizado) {
        return medicosRepository.findById(idMedico).map(m -> {
            m.setNombreCompleto(actualizado.getNombreCompleto());
            m.setEspecialidad(actualizado.getEspecialidad());
            m.setNumeroColegiado(actualizado.getNumeroColegiado());
            m.setCorreoElectronico(actualizado.getCorreoElectronico());
            return medicosRepository.save(m);
        });
    }

    public boolean deleteMedico(Long idMedico) {
        if (medicosRepository.existsById(idMedico)) {
            medicosRepository.deleteById(idMedico);
            return true;
        }
        return false;
    }
}