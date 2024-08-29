package healthcare.menu;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {

            loadMenuOptions();

        }

        public static void loadMenuOptions()
        {
                try(Scanner scanner = new Scanner(System.in);
                    SessionFactory sessionFactory = new Configuration().
                            configure("hibernate.cfg.xml").buildSessionFactory();) {
                    mainMenuOptions();
                    System.out.println("Enter a choice");
                    int choice = scanner.nextInt();
                    while (choice != 4) {
                        switch (choice) {
                            case 1:

                                PatientMain.managePatients(sessionFactory, scanner);
                                break;
                            case 2:
                                DoctorMain.manageDoctors(sessionFactory, scanner);
                                break;
                            case 3:
                                AppointmentMain.manageAppointments(sessionFactory, scanner);
                                break;

                            default:
                                System.out.println("Invalid choice");
                                break;
                        }
                        mainMenuOptions();
                        System.out.println("Enter a choice");
                        choice = scanner.nextInt();
                    }
                }catch(SQLException e){
                    e.printStackTrace();
                }
        }
        public static void mainMenuOptions()
        {
            System.out.println("--- MAIN MENU ---");
            System.out.println("1. Manage Patients");
            System.out.println("2. Manage Doctors");
            System.out.println("3. Manage Appointments");
            System.out.println("4. Exit");
        }
}
