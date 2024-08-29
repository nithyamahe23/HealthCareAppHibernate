package healthcare.repository;

import healthcare.model.Doctor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class DoctorRepositoryImpl {

    SessionFactory sessionFactory;

    public DoctorRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //Create Doctor
    public void createDoctor(Doctor doctor) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(doctor);
            transaction.commit();
        }
    }

    //Read Doctor by ID
    public Doctor getDoctorById(int id){
        try(Session session = sessionFactory.openSession()) {
            return session.get(Doctor.class, id);
        }
    }

    //Read all Doctors
    public List<Doctor> getAllDoctors()
    {
        try(Session session = sessionFactory.openSession()) {
            List<Doctor> doctors = session.createQuery("from Doctor", Doctor.class).list();
            return doctors;
        }
    }

    //Update Doctor
    public void updateDoctor(Doctor doctor){
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(doctor);
            transaction.commit();
        }
    }

    //Delete Doctor
    public void deleteDoctor(int id){
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Doctor doctor = session.get(Doctor.class, id);
            if(doctor != null)
            {
                session.remove(doctor);
            }
        }
    }
}
