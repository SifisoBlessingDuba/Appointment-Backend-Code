package za.co.mywebsite.Service;

import za.co.mywebsite.domain.Admin;

import java.util.List;

public interface IAdminService extends IService<Admin, Integer> {
    Admin findById(Integer adminID);

    List<Admin> getAll();


}
