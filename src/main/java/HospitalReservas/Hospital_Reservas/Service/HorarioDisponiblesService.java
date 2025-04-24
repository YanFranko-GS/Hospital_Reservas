package HospitalReservas.Hospital_Reservas.Service;

import HospitalReservas.Hospital_Reservas.Modal.HorarioDisponibles;
import HospitalReservas.Hospital_Reservas.Repository.HorariosDisponiblesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioDisponiblesService {

    @Autowired
    private HorariosDisponiblesRepository horariosDisponiblesRepository;

    public Optional<HorarioDisponibles> findByIdHorario(Long idHorario) {
        return horariosDisponiblesRepository.findByIdHorario(idHorario);
    }

    public Optional<HorarioDisponibles> findByFechaDisponibilidad(String fechaDisponibilidad) {
        return horariosDisponiblesRepository.findByFechaDisponibilidad(fechaDisponibilidad);
    }

    public HorarioDisponibles saveHorarioDisponible(HorarioDisponibles horarioDisponibles) {
        return horariosDisponiblesRepository.save(horarioDisponibles);
    }

    public List<HorarioDisponibles> listarHorarioDisponibles() {
        return horariosDisponiblesRepository.findAll();
    }

    public Optional<HorarioDisponibles> actualizarHorario(Long idHorario, HorarioDisponibles actualizado) {
        return horariosDisponiblesRepository.findById(idHorario).map(h -> {
            h.setFechaDisponibilidad(actualizado.getFechaDisponibilidad());
            h.setHoraInicio(actualizado.getHoraInicio());
            h.setHoraFin(actualizado.getHoraFin());
            h.setEstado(actualizado.getEstado());
            return horariosDisponiblesRepository.save(h);
        });
    }

    public boolean deleteHorarioDisponible(Long idHorario) {
        if (horariosDisponiblesRepository.existsById(idHorario)) {
            horariosDisponiblesRepository.deleteById(idHorario);
            return true;
        }
        return false;
    }
}