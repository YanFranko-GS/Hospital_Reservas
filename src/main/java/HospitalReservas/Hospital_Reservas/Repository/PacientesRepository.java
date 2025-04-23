package HospitalReservas.Hospital_Reservas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import HospitalReservas.Hospital_Reservas.Modal.Pacientes;

@Repository
public interface PacientesRepository extends JpaRepository<Pacientes, Long> {
    
    Pacientes findByid_paciente(Long id_paciente);
    Pacientes findBycorreo_electronico(String correo_electronico);
    Pacientes findBytelefono(int telefono);
    Pacientes findBynumero_documento(String numero_documento);

    //esto es el id tiene que jalar el historial por el momento no tendra una funcion NO OLVIDAR
    Pacientes findByhistorial_medico(Long historial_medico);


}
