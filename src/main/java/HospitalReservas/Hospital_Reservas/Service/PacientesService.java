package HospitalReservas.Hospital_Reservas.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HospitalReservas.Hospital_Reservas.Modal.Pacientes;
import HospitalReservas.Hospital_Reservas.Repository.PacientesRepository;

@Service
public class PacientesService {   
    @Autowired
    private PacientesRepository pacientesRepository;

    public Pacientes findByid_paciente(Long id_paciente) {
        return pacientesRepository.findByid_paciente(id_paciente);
    }

    public Pacientes findBycorreo_electronico(String correo_electronico) {
        return pacientesRepository.findBycorreo_electronico(correo_electronico);
    }

    public Pacientes findBytelefono(int telefono) {
        return pacientesRepository.findBytelefono(telefono);
    }

    public Pacientes findBynumero_documento(String numero_documento) {
        return pacientesRepository.findBynumero_documento(numero_documento);
    }

    // Esto está para corregir por el momento, aún no se necesita
    // public Pacientes findByhistorial_medico(Long historial_medico) {
    //     return pacientesRepository.findByhistorial_medico(historial_medico);
    // }


    
    // Funciones CRUD

    // Guardar un paciente
    public Pacientes savePacientes(Pacientes paciente) {
        return pacientesRepository.save(paciente);
    }

    // Obtener ID de los pacientes
    public Optional<Pacientes> obtenerPacientesPorId(Long id_paciente) {
        return pacientesRepository.findById(id_paciente);
    }

    // Crear nuevo paciente (NO funciona)

    //public Pacientes crearPacientes(Pacientes paciente) {
    //    return pacientesRepository.save(paciente); 
    //}


    //listar a todos los pacientes
    public List<Pacientes> listarPacientes() {
        return pacientesRepository.findAll(); 
    }


    // Actualizar un paciente
    public Optional<Pacientes> actualizarPacientes(Long id_paciente, Pacientes pacienteActualizado) {
        return pacientesRepository.findById(id_paciente).map(pacientes -> {            
            pacientes.setNombre_completo(pacienteActualizado.getNombre_completo());
            pacientes.setFecha_nacimiento(pacienteActualizado.getFecha_nacimiento());
            pacientes.setCorreo_electronico(pacienteActualizado.getCorreo_electronico());
            pacientes.setTelefono(pacienteActualizado.getTelefono());
            pacientes.setDireccion(pacienteActualizado.getDireccion());
            pacientes.setSexo(pacienteActualizado.getSexo());
            pacientes.setTipo_documento(pacienteActualizado.getTipo_documento());
            pacientes.setNumero_documento(pacienteActualizado.getNumero_documento());
            return pacientesRepository.save(pacientes); 
        });
    }

    // eliminarar un paciente por si id pero pasara por un booleano
    // para saber si se elimino o no
    public boolean deletePacientes(Long id_paciente) {
        if (pacientesRepository.existsById(id_paciente)) { 
            pacientesRepository.deleteById(id_paciente); 
            return true;
        }
        return false;
    }
}