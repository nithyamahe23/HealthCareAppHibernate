package healthcare.menu;


import healthcare.model.Doctor;
import healthcare.repository.DoctorRepositoryImpl;
import healthcare.service.DoctorService;

import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class DoctorMain {
    public static void manageDoctors(SessionFactory sessionFactory, Scanner scanner) throws SQLException{
        DoctorRepositoryImpl doctorRepositoryImpl = new DoctorRepositoryImpl(sessionFactory);
        DoctorService doctorService = new DoctorService(doctorRepositoryImpl);
       loadDoctorsMenu();
        System.out.println("Enter a choice : ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        while(choice != 6){
            switch (choice) {
                case 1:
                    // Create Doctor
                    Doctor newDoctor = new Doctor();
                    System.out.print("Enter first name: ");
                    newDoctor.setFirstName(scanner.nextLine());
                    System.out.print("Enter last name: ");
                    newDoctor.setLastName(scanner.nextLine());
                    System.out.print("Enter Specialty: ");
                    newDoctor.setSpeciality(scanner.nextLine());
                    System.out.print("Enter email: ");
                    newDoctor.setEmail(scanner.nextLine());

                    doctorService.createDoctor(newDoctor);
                    System.out.println("Doctor created successfully.");
                    break;
                case 2:
                    // Read Doctor
                    System.out.print("Enter Doctor ID: ");
                    int doctorId = scanner.nextInt();
                    Doctor doctor = doctorService.getDoctorById(doctorId);
                    if (doctor != null) {
                        System.out.println("Doctor ID: " + doctor.getDoctorId());
                        System.out.println("Name: " + doctor.getFirstName() + " " + doctor.getLastName());
                        System.out.println("Specialty: " + doctor.getSpeciality());
                        System.out.println("Email: " + doctor.getEmail());
                    } else {
                        System.out.println("Doctor not found.");
                    }
                    break;
                case 3:
                    // Update Doctor
                    System.out.print("Enter Doctor ID: ");
                    doctorId = scanner.nextInt();
                    scanner.nextLine();  // consume newline
                    doctor = doctorService.getDoctorById(doctorId);
                    if (doctor != null) {
                        System.out.print("Enter new first name: ");
                        doctor.setFirstName(scanner.nextLine());
                        System.out.print("Enter new last name: ");
                        doctor.setLastName(scanner.nextLine());
                        System.out.print("Enter Specialty ");
                        doctor.setSpeciality(scanner.nextLine());
                        System.out.print("Enter new email: ");
                        doctor.setEmail(scanner.nextLine());

                        doctorService.updateDoctor(doctor);
                        System.out.println("Doctor updated successfully.");
                    } else {
                        System.out.println("Doctor not found.");
                    }
                    break;
                case 4:
                    // Delete Doctor
                    System.out.print("Enter Doctor ID: ");
                    doctorId = scanner.nextInt();
                    doctor = doctorService.getDoctorById(doctorId);
                    if(doctor != null) {
                        doctorService.deleteDoctor(doctorId);
                        System.out.println("Patient deleted successfully.");
                    }else {
                        System.out.println("Doctor not found.");
                    }
                    break;
                case 5:
                    //Print all doctor details
                    List<Doctor> doctors = doctorService.getAllDoctors();
                    for(Doctor doctorObj : doctors) {
                        System.out.println(doctorObj);
                    }
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
            loadDoctorsMenu();
            System.out.println("Enter a choice : ");
            choice = scanner.nextInt();
            scanner.nextLine();
        }

        }

        public static void loadDoctorsMenu()
        {
            System.out.println("---DOCTORS MENU---");
            System.out.println("1. Create Doctor");
            System.out.println("2. Read Doctor");
            System.out.println("3. Update Doctor");
            System.out.println("4. Delete Doctor");
            System.out.println("5. Print Doctors");
            System.out.println("6. Exit");
        }
        }