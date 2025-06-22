package za.co.mywebsite.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Integer appointmentId;
    private String Description;
    private String Location;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "Admin_id")
    private Admin admin;
    protected Appointment(){

    }
    private Appointment(Builder builder) {
        this.appointmentId = builder.appointmentId;
        this.Description = builder.Description;
        this.Location = builder.Location;
        this.date = builder.date;
        this.admin = builder.admin;
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public String getDescription() {
        return Description;
    }

    public String getLocation() {
        return Location;
    }

    public LocalDate getDate() {
        return date;
    }
    public Admin getAdmin() {
        return admin;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", Description='" + Description + '\'' +
                ", Location='" + Location + '\'' +
                ", date=" + date +
                ", admin=" + admin +
                '}';
    }

    public static class Builder{
        private Integer appointmentId;
        private String Description;
        private String Location;
        private LocalDate date;
        private Admin admin;

        public Builder setAppointmentId(Integer appointmentId){
            this.appointmentId = appointmentId;
            return this;
        }
        public Builder setDescription(String description){
            this.Description = description;
            return this;
        }
        public Builder setLocation(String location){
            this.Location = location;
            return this;
        }
        public Builder setDate(LocalDate date){
            this.date = date;
            return this;
        }
        public Builder setAdmin(Admin admin){
            this.admin = admin;
            return this;
        }
        public Appointment build(){
            return new Appointment(this);
        }
    }


}
