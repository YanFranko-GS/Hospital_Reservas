package HospitalReservas.Hospital_Reservas.Service;

import HospitalReservas.Hospital_Reservas.Modal.Pacientes;
import HospitalReservas.Hospital_Reservas.Repository.PacientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacientesService {

    @Autowired
    private PacientesRepository pacientesRepository;

    public Optional<Pacientes> findByIdPaciente(Long idPaciente) {
        return pacientesRepository.findByIdPaciente(idPaciente);
    }

    public Optional<Pacientes> findByCorreoElectronico(String correoElectronico) {
        return pacientesRepository.findByCorreoElectronico(correoElectronico);
    }

    public Optional<Pacientes> findByTelefono(int telefono) {
        return pacientesRepository.findByTelefono(telefono);
    }

    public Optional<Pacientes> findByNumeroDocumento(String numeroDocumento) {
        return pacientesRepository.findByNumeroDocumento(numeroDocumento);
    }

    public Pacientes savePacientes(Pacientes paciente) {
        return pacientesRepository.save(paciente);
    }

    public Optional<Pacientes> obtenerPacientesPorId(Long idPaciente) {
        return pacientesRepository.findById(idPaciente);
    }

    public List<Pacientes> listarPacientes() {
        return pacientesRepository.findAll();
    }

    public Optional<Pacientes> actualizarPacientes(Long idPaciente, Pacientes actualizado) {
        return pacientesRepository.findById(idPaciente).map(p -> {
            p.setNombreCompleto(actualizado.getNombreCompleto());
            p.setFechaNacimiento(actualizado.getFechaNacimiento());
            p.setCorreoElectronico(actualizado.getCorreoElectronico());
            p.setTelefono(actualizado.getTelefono());
            p.setDireccion(actualizado.getDireccion());
            p.setSexo(actualizado.getSexo());
            p.setTipoDocumento(actualizado.getTipoDocumento());
            p.setNumeroDocumento(actualizado.getNumeroDocumento());
            return pacientesRepository.save(p);
        });
    }

    public boolean deletePacientes(Long idPaciente) {
        if (pacientesRepository.existsById(idPaciente)) {
            pacientesRepository.deleteById(idPaciente);
            return true;
        }
        return false;
    }
}
