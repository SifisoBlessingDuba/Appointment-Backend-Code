package za.co.mywebsite.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.mywebsite.domain.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    @Override
    Admin save(Admin admin);

    @Override
    List<Admin> findAll();

    @Override
    void deleteById(Integer id);

    @Override
    Optional<Admin> findById(Integer integer);
}
