package za.co.mywebsite.Service;

import za.co.mywebsite.domain.Admin;
import za.co.mywebsite.domain.Appointment;

import java.util.List;

public interface IAppointment extends IService<Appointment, Integer> {
    Appointment findById(Integer appointmentID);

    List<Appointment> getAll();
}
