package healthcare.service;

import healthcare.model.Doctor;
import healthcare.repository.DoctorRepositoryImpl;

import java.util.List;

public class DoctorService {

    private final DoctorRepositoryImpl doctorRepositoryImpl;

    public DoctorService(DoctorRepositoryImpl doctorRepositoryImpl) {
        this.doctorRepositoryImpl = doctorRepositoryImpl;
    }

    public void createDoctor(Doctor doctor){
        doctorRepositoryImpl.createDoctor(doctor);
    }

    public Doctor getDoctorById(int id){
        return doctorRepositoryImpl.getDoctorById(id);
    }

    public List<Doctor> getAllDoctors(){
        return doctorRepositoryImpl.getAllDoctors();
    }

    public void updateDoctor(Doctor doctor){
        doctorRepositoryImpl.updateDoctor(doctor);
    }

    public void deleteDoctor(int id){
        doctorRepositoryImpl.deleteDoctor(id);
    }
}
