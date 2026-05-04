package oopsproject;

import java.util.ArrayList;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;

public class HostelSystem {

    private ArrayList<Room> rooms;
    private ArrayList<Complaint> complaints;
    private ArrayList<Student> students;
    private int ticketCounter;

    private static final String STUDENTS_FILE = "students.txt";
    private static final String COMPLAINTS_FILE = "complaints.txt";

    public HostelSystem() {
        rooms = new ArrayList<>();
        complaints = new ArrayList<>();
        students = new ArrayList<>();
        ticketCounter = 1;

        for (int i = 1; i <= 5; i++) {
            rooms.add(new Room(i));
        }

        System.out.println("Hostel System initialized with 5 rooms.");

        loadStudentsFromFile();
        loadComplaintsFromFile();
    }

    public void registerStudent(int id, String name) {
        if (id <= 0) {
            System.out.println("Invalid ID number! Please enter a positive integer.");
            return;
        }
        for (Student s : students) {
            if (s.getID() == id) {
                System.out.println("Student with ID " + id + " already exists!");
                return;
            }
        }
        Student s = new Student(name, id);
        students.add(s);
        System.out.println("Student registered: " + name + " (ID: " + id + ")");
        saveStudentsToFile();
    }

    public void allocateRoom() {
        for (Student s : students) {
            if (!s.isRoomAllocated()) {
                for (Room r : rooms) {
                    if (!r.isOccupied()) {
                        r.setOccupied(true);
                        s.setRoomAllocated(true);
                        System.out.println("Room " + r.getRoomNumber() + " allocated to " + s.getName());
                        saveStudentsToFile();
                        return;
                    }
                }
                System.out.println("Sorry! No free rooms available.");
                return;
            }
        }
        System.out.println("No student to allocate room.");
    }

    public void allocateRoomForStudent(Student student) {
        if (student.isRoomAllocated()) {
            System.out.println("You already have a room allocated!");
            return;
        }
        for (Room r : rooms) {
            if (!r.isOccupied()) {
                r.setOccupied(true);
                student.setRoomAllocated(true);
                System.out.println("Room " + r.getRoomNumber() + " allocated to " + student.getName());
                saveStudentsToFile();
                return;
            }
        }
        System.out.println("Sorry! No free rooms available right now.");
    }

    public void searchStudentByName(String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                System.out.println(s);
                return;
            }
        }
        System.out.println("Student not found");
    }

    public void generateComplaint(String issue) {
        Complaint c = new Complaint(ticketCounter, issue);
        complaints.add(c);
        System.out.println("Complaint filed! Ticket #" + ticketCounter + " -> " + issue);
        ticketCounter++;
        saveComplaintsToFile();
    }

    public void viewComplaints() {
        System.out.println("\n--- All Complaints ---");
        if (complaints.isEmpty()) {
            System.out.println("No complaints filed yet.");
        } else {
            for (Complaint c : complaints) {
                System.out.println(c);
            }
        }
    }

    public void showOccupancy() {
        System.out.println("\n--- Room Occupancy Status ---");
        for (Room r : rooms) {
            System.out.println(r);
        }
    }

    public void viewAllFeeStatus() {
        System.out.println("\n--- Fee Status of All Students ---");
        if (students.isEmpty()) {
            System.out.println("No students registered yet.");
        } else {
            for (Student s : students) {
                s.viewFeeStatus();
            }
        }
    }

    public void viewAllStudents() {
        System.out.println("\n--- All Registered Students ---");
        if (students.isEmpty()) {
            System.out.println("No students registered yet.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    public void updateComplaintStatus(int ticketId, String status) {
        for (Complaint c : complaints) {
            if (c.getTicketId() == ticketId) {
                c.updateStatus(status);
                System.out.println("Ticket #" + ticketId + " updated to: " + status);
                saveComplaintsToFile();
                return;
            }
        }
        System.out.println("Ticket #" + ticketId + " not found!");
    }

    public void payFee(int studentId, int amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount! Please enter a positive value.");
            return;
        }
        for (Student s : students) {
            if (s.getID() == studentId) {
                s.setFeePaid(s.getFeePaid() + amount);
                System.out.println("Rs." + amount + " fee paid for " + s.getName());
                saveStudentsToFile();
                return;
            }
        }
        System.out.println("Student with ID " + studentId + " not found!");
    }

    public Student findStudentById(int id) {
        for (Student s : students) {
            if (s.getID() == id) {
                return s;
            }
        }
        return null;
    }

    public void saveStudentsToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(STUDENTS_FILE))) {
            for (Student s : students) {
                bw.write("Student id: " + s.getID() + "," + " Student name: "+ s.getName() + "," +" Room allocated: "+ s.isRoomAllocated() + "," +" Fee paid: "+ s.getFeePaid());
                bw.newLine();
            }
            bw.close();
            System.out.println("[File] Student data saved to " + STUDENTS_FILE);
        } catch (IOException e) {
            System.out.println("[File Error] Could not save students: " + e.getMessage());
        }
    }

    public void loadStudentsFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(STUDENTS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                boolean roomAllocated = Boolean.parseBoolean(parts[2]);
                int feePaid = Integer.parseInt(parts[3]);

                Student s = new Student(name, id);
                s.setRoomAllocated(roomAllocated);
                s.setFeePaid(feePaid);
                students.add(s);

                if (roomAllocated && !rooms.isEmpty()) {
                    for (Room r : rooms) {
                        if (!r.isOccupied()) {
                            r.setOccupied(true);
                            break;
                        }
                    }
                }
            }
            br.close();
            System.out.println("[File] Student data loaded from " + STUDENTS_FILE);
        } catch (IOException e) {
            System.out.println("[File] No existing student data found. Starting fresh.");
        }
    }

    public void saveComplaintsToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(COMPLAINTS_FILE))) {
            for (Complaint c : complaints) {
                bw.write("Id: "+ c.getTicketId() + ",  "+ " Complain: " + c.getIssue() + ","+ " Status:  " + c.getStatus());
                bw.newLine();
            }
            bw.close();
            System.out.println("[File] Complaint data saved to " + COMPLAINTS_FILE);
        } catch (IOException e) {
            System.out.println("[File Error] Could not save complaints: " + e.getMessage());
        }
    }

    public void loadComplaintsFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(COMPLAINTS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 3);
                int ticketId = Integer.parseInt(parts[0]);
                String issue = parts[1];
                String status = parts[2];

                Complaint c = new Complaint(ticketId, issue);
                c.updateStatus(status);
                complaints.add(c);

                if (ticketId >= ticketCounter) {
                    ticketCounter = ticketId + 1;
                }
            }
            br.close();
            System.out.println("[File] Complaint data loaded from " + COMPLAINTS_FILE);
        } catch (IOException e) {
            System.out.println("[File] No existing complaint data found. Starting fresh.");
        }
    }
}
