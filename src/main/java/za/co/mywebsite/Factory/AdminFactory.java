package za.co.mywebsite.Factory;

import za.co.mywebsite.domain.Admin;
import za.co.mywebsite.util.Helper;

public class AdminFactory {
    public static Admin createAdmin(Integer adminId , String adminName, String email, String password, String number){
        if(!Helper.isValidErfNumber(adminId) ||
        Helper.isNullOrEmpty(adminName) ||
        Helper.isNullOrEmpty(email) ||
        Helper.isNullOrEmpty(password) ||
        Helper.isNullOrEmpty(number)){
            return null;
        }
        return new Admin.Builder()
                .setAdminId(adminId)
                .setAdminName(adminName)
                .setEmail(email)
                .setPassword(password)
                .setNumber(number)
                .build();
    }
}
