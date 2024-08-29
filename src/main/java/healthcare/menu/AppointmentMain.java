package healthcare.menu;


import healthcare.model.Appointment;
import healthcare.repository.AppointmentRepositoryImpl;
import healthcare.service.AppointmentService;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AppointmentMain {
    public static void manageAppointments(SessionFactory sessionFactory, Scanner scanner) throws SQLException {
        AppointmentRepositoryImpl appointmentRepositoryImpl = new AppointmentRepositoryImpl(sessionFactory);
        AppointmentService appointmentService = new AppointmentService(appointmentRepositoryImpl);
        loadAppointmentsMenu();
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        while(choice != 6) {
                switch (choice) {
                    case 1:
                        // Create Appointment
                        Appointment appointment = new Appointment();
                        System.out.print("Enter Patient ID: ");
                        appointment.setPatientId(scanner.nextInt());
                        System.out.print("Enter Doctor ID: ");
                        appointment.setDoctorId(scanner.nextInt());
                        scanner.nextLine(); //Since there is a change in datatype
                        System.out.print("Enter Appointment Date: ");
                        appointment.setAppointmentDate(scanner.nextLine());
                        System.out.print("Enter Notes: ");
                        appointment.setNotes(scanner.nextLine());

                        appointmentService.createAppointment(appointment);
                        System.out.println("Appointment created successfully.");
                        break;
                    case 2:
                        // Read Appointment
                        System.out.print("Enter Appointment ID: ");
                        int appointmentId = scanner.nextInt();
                        appointment = appointmentService.getAppointmentById(appointmentId);
                        if (appointment != null) {
                            System.out.println("Appointment ID: " + appointment.getAppointmentId());
                            System.out.println("Patient ID: " + appointment.getPatientId());
                            System.out.println("Doctor ID: " + appointment.getDoctorId());
                            System.out.println("Appointment Date: " + appointment.getAppointmentDate());
                            System.out.println("Notes: " + appointment.getNotes());
                        } else {
                            System.out.println("Appointment not found.");
                        }
                        break;
                    case 3:
                        // Update Appointment
                        System.out.print("Enter Appointment ID: ");
                        appointmentId = scanner.nextInt();
                        scanner.nextLine();  // consume newline
                        appointment = appointmentService.getAppointmentById(appointmentId);
                        if (appointment != null) {
                            System.out.print("Enter Patient ID: ");
                            appointment.setPatientId(scanner.nextInt());
                            System.out.print("Enter Doctor ID: ");
                            appointment.setDoctorId(scanner.nextInt());
                            scanner.nextLine();
                            System.out.print("Enter Appointment Date: ");
                            appointment.setAppointmentDate(scanner.nextLine());
                            System.out.print("Enter Notes: ");
                            appointment.setNotes(scanner.nextLine());

                            appointmentService.updateAppointment(appointment);
                            System.out.println("Appointment updated successfully.");
                        } else {
                            System.out.println("Appointment not found.");
                        }
                        break;
                    case 4:
                        // Delete Appointment
                        System.out.print("Enter Appointment ID: ");
                        appointmentId = scanner.nextInt();
                        appointment = appointmentService.getAppointmentById(appointmentId);
                        if(appointment != null) {
                            appointmentService.deleteAppointment(appointmentId);
                            System.out.println("Appointment deleted successfully.");
                        }else {
                            System.out.println("Appointment not found.");
                        }
                        break;
                    case 5:
                        //Print all doctor details
                        List<Appointment> appointments = appointmentService.getAllAppointments();
                        for(Appointment appointmentObj : appointments) {
                            System.out.println(appointmentObj);
                        }
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            loadAppointmentsMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
        }
        }

        public static void loadAppointmentsMenu(){
            System.out.println("--- APPOINTMENTS MENU ---");
            System.out.println("1. Create Appointment");
            System.out.println("2. Read Appointment");
            System.out.println("3. Update Appointment");
            System.out.println("4. Delete Appointment");
            System.out.println("5. Print Appointment");
            System.out.println("6. Exit");
        }

}

