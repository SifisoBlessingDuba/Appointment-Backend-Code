package za.co.mywebsite.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;
    private String adminName;
    private String email;
    private String password;
    private String number;

    protected Admin(){

    }
    public Admin(Builder builder){
        this.adminId = builder.adminId;
        this.adminName = builder.adminName;
        this.email = builder.email;
        this.password = builder.password;
        this.number = builder.number;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNumber() {
        return number;
    }
    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
    public static class Builder{
        private Integer adminId;
        private String adminName;
        private String email;
        private String password;
        private String number;

        public Builder setAdminId(Integer adminId){
            this.adminId = adminId;
            return this;
        }
        public Builder setAdminName(String adminName){
            this.adminName = adminName;
            return this;
        }
        public Builder setEmail(String email){
            this.email = email;
            return this;
        }
        public Builder setPassword(String password){
            this.password = password;
            return this;
        }
        public Builder setNumber(String number){
            this.number = number;
            return this;
        }
        public Admin build(){
            return new Admin(this);
        }
    }
}
