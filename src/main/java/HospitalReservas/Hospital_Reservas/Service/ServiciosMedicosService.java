package HospitalReservas.Hospital_Reservas.Service;

import HospitalReservas.Hospital_Reservas.Modal.ServiciosMedicos;
import HospitalReservas.Hospital_Reservas.Repository.ServiciosMedicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiciosMedicosService {

    @Autowired
    private ServiciosMedicosRepository serviciosMedicosRepository;

    public Optional<ServiciosMedicos> findByIdServicio(Long idServicio) {
        return serviciosMedicosRepository.findByIdServicio(idServicio);
    }

    public Optional<ServiciosMedicos> findByNombreServicio(String nombreServicio) {
        return serviciosMedicosRepository.findByNombreServicio(nombreServicio);
    }

    public ServiciosMedicos saveServicioMedico(ServiciosMedicos serviciosMedicos) {
        return serviciosMedicosRepository.save(serviciosMedicos);
    }

    public List<ServiciosMedicos> listarServiciosMedicos() {
        return serviciosMedicosRepository.findAll();
    }

    public Optional<ServiciosMedicos> actualizarServicioMedico(Long idServicio, ServiciosMedicos actualizado) {
        return serviciosMedicosRepository.findById(idServicio).map(s -> {
            s.setNombreServicio(actualizado.getNombreServicio());
            s.setPrecio(actualizado.getPrecio());
            s.setDuracion(actualizado.getDuracion());
            s.setDescripcion(actualizado.getDescripcion());
            s.setEstado(actualizado.getEstado());
            return serviciosMedicosRepository.save(s);
        });
    }

    public boolean deleteServicioMedico(Long idServicio) {
        if (serviciosMedicosRepository.existsById(idServicio)) {
            serviciosMedicosRepository.deleteById(idServicio);
            return true;
        }
        return false;
    }
}