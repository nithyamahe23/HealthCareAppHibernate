package healthcare.repository;

import healthcare.model.Appointment;
import healthcare.model.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class AppointmentRepositoryImpl {
    SessionFactory sessionFactory;

    public AppointmentRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //Create new Appointment
    public void createAppointment(Appointment appointment) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(appointment);
            transaction.commit();
        }
    }

    //Read Appointment By ID
    public Appointment getAppointmentById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Appointment.class, id);
        }
    }

    //Read all Appointments
    public List<Appointment> getAllAppointments()
    {
        try(Session session = sessionFactory.openSession()) {
            return session.createQuery("from Appointment ", Appointment.class).list();
        }
    }

    //Update Appointment
    public void updateAppointment(Appointment appointment) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(appointment);
            transaction.commit();
        }
    }

    //delete appointment
    public void deleteAppointment(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Appointment appointment = session.get(Appointment.class, id);
            if (appointment != null) {
                session.remove(appointment);
            }
            transaction.commit();
        }
    }
}
