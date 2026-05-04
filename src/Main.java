package oopsproject;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    private static final String WARDEN_NAME = "Vinod";
    private static final String WARDEN_PASSWORD = "warden123";

    public static int safeNextInt(Scanner sc) {
        try {
            int value = sc.nextInt();
            sc.nextLine(); 
            return value;
        } catch (InputMismatchException e) {
            sc.nextLine(); 
            return -1; 
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HostelSystem hostel = new HostelSystem();

        Warden warden = new Warden(WARDEN_NAME, WARDEN_PASSWORD);


        System.out.println("    Welcome to Hostel Management System  ");

        int roleChoice = 0;

        while (roleChoice != 3) {

            System.out.println("\nWho are you?");
            System.out.println("1. Student");
            System.out.println("2. Warden");
            System.out.println("3. Exit System");
            System.out.print("Enter choice: ");

            roleChoice = safeNextInt(sc); 

            if (roleChoice == 1) {

                System.out.print("\nEnter your Student ID: ");
                int studentId = safeNextInt(sc); 

                if (studentId == -1) {
                    System.out.println("Invalid ID! Please enter a number.");
                    roleChoice = 0; 
                    continue;
                }

                Student student = hostel.findStudentById(studentId);

                if (student != null) {
                    User user = student;
                    user.showMenu(hostel);
                } else {
                    System.out.println("Student ID " + studentId + " not found!");
                    System.out.println("Please ask the warden to register you first");
                }

            } else if (roleChoice == 2) {

                System.out.print("\nEnter Warden Password: ");
                String enteredPassword = sc.nextLine();

                if (warden.checkPassword(enteredPassword)) {
                    User user = warden;
                    user.showMenu(hostel);
                } else {
                    System.out.println("Wrong password! Access denied");
                }

            } else if (roleChoice == 3) {
                System.out.println("\nAll data has been saved to files");
                System.out.println("Goodbye!");

            } else {
                System.out.println("Invalid choice! Please enter 1, 2 or 3");
                roleChoice = 0; 
            }
        }

        sc.close();
    }
}
