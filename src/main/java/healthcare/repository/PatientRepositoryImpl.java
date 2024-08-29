package healthcare.repository;

import healthcare.model.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class PatientRepositoryImpl {

    SessionFactory sessionFactory;

    public PatientRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //Create new Patient
    public void createPatient(Patient patient) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(patient);
            transaction.commit();
        }
    }

    //Read Patient By ID
    public Patient getPatientById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Patient.class, id);
        }
    }

    //Read all patients
    public List<Patient> getAllPatients()
    {
        try(Session session = sessionFactory.openSession()) {
            return session.createQuery("from Patient", Patient.class).list();
        }
    }

    //Update patient id
    public void updatePatient(Patient patient) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(patient);
            transaction.commit();
        }
    }

    //delete patient
    public void deletePatient(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Patient patient = session.get(Patient.class, id);
            if (patient != null) {
                session.remove(patient);
            }
            transaction.commit();
        }
    }
}
