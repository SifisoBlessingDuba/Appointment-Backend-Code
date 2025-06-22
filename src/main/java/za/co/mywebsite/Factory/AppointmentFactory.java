package za.co.mywebsite.Factory;

import za.co.mywebsite.domain.Admin;
import za.co.mywebsite.domain.Appointment;
import za.co.mywebsite.util.Helper;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AppointmentFactory {
    public static Appointment createAppointment(Integer appointmentId, String Description, String Location, LocalDate date, Admin admin ){
        if(!Helper.isValidErfNumber(appointmentId) ||
        Helper.isNullOrEmpty(Description) ||
        Helper.isNullOrEmpty(Location)){
            return null;
        }

        return new Appointment.Builder()
                .setAppointmentId(appointmentId)
                .setDescription(Description)
                .setLocation(Location)
                .setDate(date)
                .setAdmin(admin)
                .build();
    }
}
