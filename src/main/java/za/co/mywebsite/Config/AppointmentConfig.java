package za.co.mywebsite.Config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import za.co.mywebsite.domain.Admin;
import za.co.mywebsite.domain.Appointment;
import za.co.mywebsite.Repository.AdminRepository;
import za.co.mywebsite.Repository.AppointmentRepository;

import java.time.LocalDate;

@Configuration
public class AppointmentConfig {

    @Bean
    CommandLineRunner appointmentDataLoader(AppointmentRepository appointmentRepository, AdminRepository adminRepository) {
        return args -> {
            // Create or fetch an Admin
            Admin admin = new Admin.Builder()
                    //.setAdminId(1) // omit if you want auto-generated
                    .setAdminName("Admin One")
                    .setEmail("admin.one@example.com")
                    .setPassword("adminPass123")
                    .setNumber("0712345678")
                    .build();

            Admin savedAdmin = adminRepository.save(admin);

            // Create Appointment linked to the saved Admin
            Appointment appointment = new Appointment.Builder()
                    .setDescription("Initial Project Meeting")
                    .setLocation("Main Office")
                    .setDate(LocalDate.now().plusDays(3))
                    .setAdmin(savedAdmin)
                    .build();

            Appointment savedAppointment = appointmentRepository.save(appointment);

            System.out.println("Sample appointment saved: " + savedAppointment);
        };
    }
}
