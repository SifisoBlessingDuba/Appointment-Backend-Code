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
import za.co.mywebsite.Service.AdminService;
import za.co.mywebsite.domain.Admin;

import java.util.List;

@WebMvcTest(AdminController.class)
class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdminService adminService;

    private Admin sampleAdmin;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();

        sampleAdmin = new Admin.Builder()
                .setAdminId(1)
                .setAdminName("John Doe")
                .setEmail("john@example.com")
                .setPassword("password123")
                .setNumber("1234567890")
                .build();
    }

    @Test
    void testSaveAdmin_returnsSavedAdmin() throws Exception {
        when(adminService.save(any(Admin.class))).thenReturn(sampleAdmin);

        mockMvc.perform(post("/admin/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(sampleAdmin)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.adminId").value(sampleAdmin.getAdminId()))
                .andExpect(jsonPath("$.adminName").value("John Doe"))
                .andExpect(jsonPath("$.email").value("john@example.com"));

        verify(adminService).save(any(Admin.class));
    }

    @Test
    void testReadAdmin_existingId_returnsAdmin() throws Exception {
        when(adminService.findById(1)).thenReturn(sampleAdmin);

        mockMvc.perform(get("/admin/read/{adminID}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.adminId").value(1))
                .andExpect(jsonPath("$.adminName").value("John Doe"));

        verify(adminService).findById(1);
    }

    @Test
    void testReadAdmin_nonExistingId_returnsNull() throws Exception {
        when(adminService.findById(2)).thenReturn(null);

        mockMvc.perform(get("/admin/read/{adminID}", 2))
                .andExpect(status().isOk())
                .andExpect(content().string(""));

        verify(adminService).findById(2);
    }

    @Test
    void testDeleteAdmin_callsServiceDelete() throws Exception {
        doNothing().when(adminService).deleteById(1);

        mockMvc.perform(delete("/admin/delete/{adminID}", 1))
                .andExpect(status().isOk());

        verify(adminService).deleteById(1);
    }

    @Test
    void testGetAllAdmins_returnsEmptyList() throws Exception {
        when(adminService.getAll()).thenReturn(List.of());

        mockMvc.perform(get("/admin/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));

        verify(adminService).getAll();
    }
}
