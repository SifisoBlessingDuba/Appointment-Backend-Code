package za.co.mywebsite.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.mywebsite.domain.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    @Override
    Appointment save(Appointment appointment);

    @Override
    void delete(Appointment appointment);

    @Override
    Optional<Appointment> findById(Integer integer);

    @Override
    List<Appointment> findAll();
}
