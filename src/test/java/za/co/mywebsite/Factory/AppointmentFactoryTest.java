package za.co.mywebsite.Factory;

import org.junit.jupiter.api.Test;
import za.co.mywebsite.domain.Appointment;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentFactoryTest {

    @Test
    void createAppointment() {
        Appointment appointment = AppointmentFactory.createAppointment(1,"Description","Location",LocalDate.now(), null);
        assertNotNull(appointment);
        System.out.println(appointment);
    }
}