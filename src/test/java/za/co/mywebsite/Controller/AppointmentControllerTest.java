package za.co.mywebsite.Controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import za.co.mywebsite.Service.AppointmentService;
import za.co.mywebsite.domain.Admin;
import za.co.mywebsite.domain.Appointment;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDate;
import java.util.List;

@WebMvcTest(AppointmentController.class)
class AppointmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppointmentService appointmentService;

    private Appointment sampleAppointment;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

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
    void testSaveAppointment_returnsSavedAppointment() throws Exception {
        when(appointmentService.save(any(Appointment.class))).thenReturn(sampleAppointment);

        mockMvc.perform(post("/appointment/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(sampleAppointment)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.appointmentId").value(sampleAppointment.getAppointmentId()))
                .andExpect(jsonPath("$.description").value("Project Meeting"))
                .andExpect(jsonPath("$.location").value("Conference Room"))
                .andExpect(jsonPath("$.admin.adminId").value(1));

        verify(appointmentService).save(any(Appointment.class));
    }

    @Test
    void testFindById_existingAppointment_returnsAppointment() throws Exception {
        when(appointmentService.findById(1)).thenReturn(sampleAppointment);

        mockMvc.perform(get("/appointment/read/{appointmentID}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.appointmentId").value(1))
                .andExpect(jsonPath("$.description").value("Project Meeting"))
                .andExpect(jsonPath("$.admin.adminName").value("Admin One"));

        verify(appointmentService).findById(1);
    }

    @Test
    void testFindById_nonExistingAppointment_returnsEmpty() throws Exception {
        when(appointmentService.findById(2)).thenReturn(null);

        mockMvc.perform(get("/appointment/read/{appointmentID}", 2))
                .andExpect(status().isOk())
                .andExpect(content().string(""));

        verify(appointmentService).findById(2);
    }

    @Test
    void testDeleteById_callsServiceDelete() throws Exception {
        doNothing().when(appointmentService).deleteById(1);

        mockMvc.perform(delete("/appointment/delete/{appointmentID}", 1))
                .andExpect(status().isOk());

        verify(appointmentService).deleteById(1);
    }

    @Test
    void testGetAll_returnsEmptyList() throws Exception {
        when(appointmentService.getAll()).thenReturn(List.of());

        mockMvc.perform(get("/appointment/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));

        verify(appointmentService).getAll();
    }
}
