package za.co.mywebsite.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import za.co.mywebsite.Repository.AdminRepository;
import za.co.mywebsite.domain.Admin;

class AdminServiceTest {

    @Mock
    private AdminRepository adminRepository;

    @InjectMocks
    private AdminService adminService;

    private Admin sampleAdmin;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        sampleAdmin = new Admin.Builder()
                .setAdminId(1)
                .setAdminName("John Doe")
                .setEmail("john@example.com")
                .setPassword("password123")
                .setNumber("1234567890")
                .build();
    }

    @Test
    void testFindById_existingAdmin_returnsAdmin() {
        when(adminRepository.findById(1)).thenReturn(Optional.of(sampleAdmin));

        Admin found = adminService.findById(1);

        assertNotNull(found);
        assertEquals(sampleAdmin.getAdminId(), found.getAdminId());
        verify(adminRepository).findById(1);
    }

    @Test
    void testFindById_nonExistingAdmin_returnsNull() {
        when(adminRepository.findById(2)).thenReturn(Optional.empty());

        Admin found = adminService.findById(2);

        assertNull(found);
        verify(adminRepository).findById(2);
    }

    @Test
    void testSaveAdmin_success() {
        when(adminRepository.save(sampleAdmin)).thenReturn(sampleAdmin);

        Admin saved = adminService.save(sampleAdmin);

        assertNotNull(saved);
        assertEquals(sampleAdmin.getAdminId(), saved.getAdminId());
        verify(adminRepository).save(sampleAdmin);
    }

    @Test
    void testDeleteById_callsRepositoryDelete() {
        doNothing().when(adminRepository).deleteById(1);

        adminService.deleteById(1);

        verify(adminRepository).deleteById(1);
    }

    @Test
    void testGetAll_returnsEmptyList() {
        List<Admin> allAdmins = adminService.getAll();

        assertNotNull(allAdmins);
        assertTrue(allAdmins.isEmpty());
    }
}
