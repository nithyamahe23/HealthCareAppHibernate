package healthcare.service;

import healthcare.model.Appointment;
import healthcare.model.Doctor;
import healthcare.repository.AppointmentRepositoryImpl;
import healthcare.repository.DoctorRepositoryImpl;

import java.util.List;

public class AppointmentService {
    private final AppointmentRepositoryImpl appointmentRepositoryImpl;

    public AppointmentService(AppointmentRepositoryImpl appointmentRepositoryImpl) {
        this.appointmentRepositoryImpl = appointmentRepositoryImpl;
    }

    public void createAppointment(Appointment appointment){
        appointmentRepositoryImpl.createAppointment(appointment);
    }

    public Appointment getAppointmentById(int id){
        return appointmentRepositoryImpl.getAppointmentById(id);
    }

    public List<Appointment> getAllAppointments(){
        return appointmentRepositoryImpl.getAllAppointments();
    }

    public void updateAppointment(Appointment appointment){
        appointmentRepositoryImpl.updateAppointment(appointment);
    }

    public void deleteAppointment(int id){
        appointmentRepositoryImpl.deleteAppointment(id);
    }

}
