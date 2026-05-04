package oopsproject;

import java.util.Scanner;

public class Student extends User {

    private int id;
    private boolean roomAllocated;
    private int feePaid;

    public Student() {
        super("Unknown");
        this.id = 0;
        this.roomAllocated = false;
        this.feePaid = 0;
    }

    public Student(String name, int id) {
        super(name);
        this.id = id;
        this.roomAllocated = false;
        this.feePaid = 0;
    }

    @Override
    public void logout() {
        System.out.println(name + " has logged out successfully");
    }

    @Override
    public void showMenu(HostelSystem hostel) {
        Scanner sc = new Scanner(System.in);
        int num_selected = 0;
        while (num_selected != 5) {
            System.out.println("STUDENT MENU:");
            System.out.println("1. Apply for Room");
            System.out.println("2. File a Complaint");
            System.out.println("3. Pay My Fee");
            System.out.println("4. View My Fee Status");
            System.out.println("5. Logout");
            System.out.println("Select the number correponding to your choice");
            num_selected = Main.safeNextInt(sc);

            switch (num_selected) {
                case 1:
                    hostel.allocateRoomForStudent(this);
                    break;
                case 2:
                    System.out.print("Describe your complaint: ");
                    String issue = sc.nextLine();
                    hostel.generateComplaint(issue);
                    break;
                case 3:
                    try {
                        System.out.print("Enter amount to pay (Rs.): ");
                        int amount = Main.safeNextInt(sc);
                        if (amount < 0) {
                            throw new IllegalArgumentException("Invalid amount! Please enter a valid amount.");
                        } else {
                            hostel.payFee(this.id, amount);
                        }
                    } catch (IllegalArgumentException iae) {
                        System.out.println("An error occured: " + iae.getMessage());
                    } catch (Exception e) {
                        System.out.println("An error occured:" + e.getMessage());
                    }
                    break;
                case 4:
                    this.viewFeeStatus();
                    break;
                case 5:
                    logout();
                    break;
                default:
                    System.out.println("Invalid number entered! Enter a number between 1 to 5");
            }
        }
    }

    public void applyRoom() {
        System.out.println("Name:" + name + " | ID:" + id + " has applied for a room");
        this.roomAllocated = true;
    }

    public void viewFeeStatus() {
        System.out.println("Name: " + name + " | Fee paid: " + feePaid);
    }

    public int getID() {
        return id;
    }

    public boolean isRoomAllocated() {
        return roomAllocated;
    }

    public void setRoomAllocated(boolean b) {
        this.roomAllocated = b;
    }

    public int getFeePaid() {
        return feePaid;
    }

    public void setFeePaid(int amount) {
        this.feePaid = amount;
    }

    @Override
    public String toString() {
        return ("ID: " + this.id + " | Name: " + this.name + " | Room Allocated: " + this.roomAllocated
                + " | Fee Paid: Rs." + this.feePaid);
    }

}
