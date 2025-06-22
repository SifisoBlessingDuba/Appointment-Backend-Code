package za.co.mywebsite.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import za.co.mywebsite.Repository.AppointmentRepository;
import za.co.mywebsite.domain.Admin;
import za.co.mywebsite.domain.Appointment;

class AppointmentServiceTest {

    @Mock
    private AppointmentRepository appointmentRepository;

    @InjectMocks
    private AppointmentService appointmentService;

    private Appointment sampleAppointment;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        Admin sampleAdmin = new Admin.Builder()
                .setAdminId(1)
                .setAdminName("Admin One")
                .setEmail("admin@example.com")
                .setPassword("adminPass")
                .setNumber("123456789")
                .build();

        sampleAppointment = new Appointment.Builder()
                .setAppointmentId(1)
                .setDescription("Project Meeting")
                .setLocation("Conference Room")
                .setDate(LocalDate.of(2025, 6, 22))
                .setAdmin(sampleAdmin)
                .build();
    }

    @Test
    void testFindById_existingAppointment_returnsAppointment() {
        when(appointmentRepository.findById(1)).thenReturn(Optional.of(sampleAppointment));

        Appointment found = appointmentService.findById(1);

        assertNotNull(found);
        assertEquals(sampleAppointment.getAppointmentId(), found.getAppointmentId());
        assertEquals("Project Meeting", found.getDescription());
        verify(appointmentRepository).findById(1);
    }

    @Test
    void testFindById_nonExistingAppointment_returnsNull() {
        when(appointmentRepository.findById(2)).thenReturn(Optional.empty());

        Appointment found = appointmentService.findById(2);

        assertNull(found);
        verify(appointmentRepository).findById(2);
    }

    @Test
    void testSaveAppointment_success() {
        when(appointmentRepository.save(sampleAppointment)).thenReturn(sampleAppointment);

        Appointment saved = appointmentService.save(sampleAppointment);

        assertNotNull(saved);
        assertEquals(sampleAppointment.getAppointmentId(), saved.getAppointmentId());
        verify(appointmentRepository).save(sampleAppointment);
    }

    @Test
    void testDeleteById_callsRepositoryDelete() {
        doNothing().when(appointmentRepository).deleteById(1);

        appointmentService.deleteById(1);

        verify(appointmentRepository).deleteById(1);
    }

    @Test
    void testGetAll_returnsEmptyList() {
        List<Appointment> allAppointments = appointmentService.getAll();

        assertNotNull(allAppointments);
        assertTrue(allAppointments.isEmpty());
    }
}
