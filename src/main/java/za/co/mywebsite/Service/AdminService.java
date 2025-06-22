package za.co.mywebsite.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.mywebsite.Repository.AdminRepository;
import za.co.mywebsite.domain.Admin;

import java.util.List;

@Service
public class AdminService implements IAdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    @Override
    public Admin findById(Integer adminID) {
        return adminRepository.findById(adminID).orElse(null);
    }

    @Override
    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public void deleteById(Integer adminID) {
        adminRepository.deleteById(adminID);
    }

    @Override
    public List<Admin> getAll() {
        return adminRepository.findAll();
    }
}
