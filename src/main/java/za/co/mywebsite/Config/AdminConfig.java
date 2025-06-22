package za.co.mywebsite.Config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import za.co.mywebsite.domain.Admin;
import za.co.mywebsite.Repository.AdminRepository;

@Configuration
public class AdminConfig {

    @Bean
    CommandLineRunner adminDataLoader(AdminRepository adminRepository) {
        return args -> {
            Admin admin = new Admin.Builder()
                    .setAdminName("Sifiso")
                    .setEmail("sifiso@gmail.com")
                    .setPassword("password")
                    .setNumber("0712345678")
                    .build();

            Admin savedAdmin = adminRepository.save(admin);

            System.out.println("Sample admin saved: " + savedAdmin);
        };
    }
}
