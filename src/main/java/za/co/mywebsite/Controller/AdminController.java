package za.co.mywebsite.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.mywebsite.Service.AdminService;
import za.co.mywebsite.domain.Admin;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/save")
    public Admin save(@RequestBody Admin admin){
        return adminService.save(admin);
    }
    @GetMapping("/read/{adminID}")
    public Admin read(@PathVariable Integer adminID){
        return adminService.findById(adminID);
    }

    @DeleteMapping("/delete/{adminID}")
    public void deleteById(@PathVariable Integer adminID){
        adminService.deleteById(adminID);
    }


    @GetMapping("/all")
    public List<Admin> getAll(){
        return adminService.getAll();
    }
}
