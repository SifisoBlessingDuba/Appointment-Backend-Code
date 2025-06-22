package za.co.mywebsite.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.mywebsite.Repository.AppointmentRepository;
import za.co.mywebsite.domain.Appointment;

import java.util.List;

@Service
public class AppointmentService implements IAppointment {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }


    @Override
    public Appointment findById(Integer appointmentID) {
        return appointmentRepository.findById(appointmentID).orElse(null);
    }

    @Override
    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public void deleteById(Integer appointmentID) {
        appointmentRepository.deleteById(appointmentID);
    }

    @Override
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }
}
