package za.co.mywebsite.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.mywebsite.Service.AppointmentService;
import za.co.mywebsite.domain.Appointment;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
    @PostMapping("/save")
    public Appointment save(@RequestBody Appointment appointment){
        return appointmentService.save(appointment);
    }
    @GetMapping("/read/{appointmentID}")
    public Appointment findById(@PathVariable Integer appointmentID){
        return appointmentService.findById(appointmentID);
    }
    @DeleteMapping("/delete/{appointmentID}")
    public void deleteById(@PathVariable Integer appointmentID){
        appointmentService.deleteById(appointmentID);
    }
    @GetMapping("/all")
    public Iterable<Appointment> getAll(){
        return appointmentService.getAll();
    }
}
