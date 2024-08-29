package healthcare.service;

import healthcare.model.Patient;
import healthcare.repository.PatientRepositoryImpl;

import java.util.List;

public class PatientService {

    private final PatientRepositoryImpl patientRepositoryImpl;

    public PatientService(PatientRepositoryImpl patientRepositoryImpl) {
        this.patientRepositoryImpl = patientRepositoryImpl;
    }

    public void createPatient(Patient patient) {
        patientRepositoryImpl.createPatient(patient);
    }

    public Patient getPatientById(int id) {
        Patient patient = patientRepositoryImpl.getPatientById(id);
        return patient;
    }

    public List<Patient> getAllPatients() {
        List<Patient> patients = patientRepositoryImpl.getAllPatients();
        return patients;
    }

    public void updatePatient(Patient patient) {
        patientRepositoryImpl.updatePatient(patient);
    }

    public void deletePatient(int id) {
        patientRepositoryImpl.deletePatient(id);
    }
}
