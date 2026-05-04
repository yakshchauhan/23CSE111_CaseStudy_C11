package oopsproject;

import java.util.Scanner;

public class Warden extends User {
    private String password;

    public Warden() {
        super("Unknown");
        this.password = null;
    }

    public Warden(String name, String password) {
        super(name);
        this.password = password;
    }

    @Override
    public void showMenu(HostelSystem hostel) {
        Scanner sc = new Scanner(System.in);
        int num_selected = 0;
        while (num_selected != 9) {
            System.out.println("1. Register new Student");
            System.out.println("2. Allocate Room to Student");
            System.out.println("3. View All Rooms");
            System.out.println("4. View All Complaints");
            System.out.println("5. Update Complaint Status");
            System.out.println("6. View All Fee Status");
            System.out.println("7. View All Students");
            System.out.println("8. Search Student by Name");
            System.out.println("9. Logout");
            System.out.println("Select the number correponding to your choice");
            num_selected = Main.safeNextInt(sc);

            switch (num_selected) {
                case 1:
                    try {
                        System.out.println("Enter Student ID:");
                        int id = Main.safeNextInt(sc);

                        if (id <= 0) {
                            throw new IllegalArgumentException("Invalid ID number! Enter the the correct ID");
                        } else {
                            System.out.print("Enter Student Name: ");
                            String student_name = sc.nextLine();
                            hostel.registerStudent(id, student_name);
                        }
                    } catch (IllegalArgumentException iae) {
                        System.out.println("An error occured: " + iae.getMessage());
                    } catch (Exception e) {
                        System.out.println("An error occured: " + e.getMessage());
                    }
                    break;
                case 2:
                    hostel.allocateRoom();
                    break;
                case 3:
                    hostel.showOccupancy();
                    break;
                case 4:
                    hostel.viewComplaints();
                    break;
                case 5:
                    try {
                        System.out.println("Enter Ticket ID: ");
                        int ticketID = Main.safeNextInt(sc);
                        if (ticketID <= 0) {
                            throw new IllegalArgumentException("Invalid Ticket ID! Please enter a valid ticket ID.");
                        } else {
                            System.out.println("Enter status of the Complaint (Pending/In Progress/Resolved): ");
                            String status = sc.nextLine();
                            hostel.updateComplaintStatus(ticketID, status);
                        }
                    } catch (IllegalArgumentException iae) {
                        System.out.println("An error occured: " + iae.getMessage());
                    } catch (Exception e) {
                        System.out.println("An error occured: " + e.getMessage());
                    }
                    break;
                case 6:
                    hostel.viewAllFeeStatus();
                    break;
                case 7:
                    hostel.viewAllStudents();
                    break;
                case 8:
                    System.out.println("Enter student name: ");
                    hostel.searchStudentByName(sc.nextLine());
                    break;
                case 9:
                    logout();
                    break;
                default:
                    System.out.println("Invalid number entered! Please enter a number between 1-9");
            }
        }
    }

    @Override
    public void logout() {
        System.out.println(this.name + " has logged out successfully");

    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}
