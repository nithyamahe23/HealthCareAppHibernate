package healthcare.menu;

import healthcare.repository.PatientRepositoryImpl;
import healthcare.service.PatientService;
import healthcare.model.Patient;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PatientMain {
    public static void managePatients(SessionFactory sessionFactory, Scanner scanner) throws SQLException{

        PatientRepositoryImpl patientRepositoryImpl = new PatientRepositoryImpl(sessionFactory);
        PatientService patientService = new PatientService(patientRepositoryImpl);
        loadPatientsMenu();
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        while(choice != 6){
            switch (choice) {
                case 1:
                    // Create Patient
                    Patient newPatient = new Patient();
                    System.out.print("Enter first name: ");
                    newPatient.setFirstName(scanner.nextLine());
                    System.out.print("Enter last name: ");
                    newPatient.setLastName(scanner.nextLine());
                    System.out.print("Enter date of birth (YYYY-MM-DD): ");
                    newPatient.setDateOfBirth(scanner.nextLine());
                    System.out.print("Enter email: ");
                    newPatient.setEmail(scanner.nextLine());
                    System.out.print("Enter phone number: ");
                    newPatient.setPhoneNumber(scanner.nextLine());
                    patientService.createPatient(newPatient);
                    System.out.println("Patient created successfully.");
                    break;
                case 2:
                    // Read Patient
                    System.out.print("Enter Patient ID: ");
                    int patientId = scanner.nextInt();
                    Patient patient = patientService.getPatientById(patientId);
                    if (patient != null) {
                        System.out.println("Patient ID: " + patient.getPatientId());
                        System.out.println("Name: " + patient.getFirstName() + " " + patient.getLastName());
                        System.out.println("Date of Birth: " + patient.getDateOfBirth());
                        System.out.println("Email: " + patient.getEmail());
                        System.out.println("Phone: " + patient.getPhoneNumber());
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;
                case 3:
                    // Update Patient
                    System.out.print("Enter Patient ID: ");
                    patientId = scanner.nextInt();
                    scanner.nextLine();  // consume newline
                    patient = patientService.getPatientById(patientId);
                    if (patient != null) {
                        System.out.print("Enter new first name: ");
                        patient.setFirstName(scanner.nextLine());
                        System.out.print("Enter new last name: ");
                        patient.setLastName(scanner.nextLine());
                        System.out.print("Enter new date of birth (YYYY-MM-DD): ");
                        patient.setDateOfBirth(scanner.nextLine());
                        System.out.print("Enter new email: ");
                        patient.setEmail(scanner.nextLine());
                        System.out.print("Enter new phone number: ");
                        patient.setPhoneNumber(scanner.nextLine());
                        patientService.updatePatient(patient);
                        System.out.println("Patient updated successfully.");
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;
                case 4:
                    // Delete Patient
                    System.out.print("Enter Patient ID: ");
                    patientId = scanner.nextInt();
                    patientService.deletePatient(patientId);
                    System.out.println("Patient deleted successfully.");
                    break;
                case 5:
                    //Display all patients
                    List<Patient> patients = patientService.getAllPatients();
                    for(Patient patientObj : patients)
                    {
                        System.out.println(patientObj);
                    }
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
            loadPatientsMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
        }

        }

        public static void loadPatientsMenu()
        {
            System.out.println(" --- PATIENTS MENU --- ");
            System.out.println("1. Create Patient");
            System.out.println("2. Read Patient");
            System.out.println("3. Update Patient");
            System.out.println("4. Delete Patient");
            System.out.println("5. Print Patients");
            System.out.println("6. Exit");
        }
    }
