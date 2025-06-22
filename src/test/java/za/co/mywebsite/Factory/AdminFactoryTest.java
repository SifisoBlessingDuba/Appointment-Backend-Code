package za.co.mywebsite.Factory;

import org.junit.jupiter.api.Test;
import za.co.mywebsite.domain.Admin;

import static org.junit.jupiter.api.Assertions.*;

class AdminFactoryTest {

    @Test
    void createAdmin() {
        Admin admin = AdminFactory.createAdmin(1, "Admin", "<EMAIL>", "admin", "0712345678");
        assertNotNull(admin);
        System.out.println(admin);
    }
}
