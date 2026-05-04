# University Hostel Management System
## Project Title
**University Hostel Management System**  
*A centralized Java-based solution to automate hostel administration, room allocation, and student grievances.*

## Team Members (with Roles)

| Member Name | Phase 1 (Planning) | Phase 2 (Design) | Phase 3 (Development) |
| :--- | :--- | :--- | :--- |
| **Akshanya S** | Class Identifying | Sequence Diagram | `HostelSystem` Class |
| **Krishna Jayakumar** | Class Identifying | Use Case Diagram | `Complaint` Class |
| **Sanjana S** | Class Identifying | Class Diagram | `User`, `Warden`, `Student` |
| **Yaksh Chauhan** | Class Identifying | Use Case Diagram | `Room` Class, `Main` |

## Problem Description
Managing hostel operations manually in universities is often inefficient, time-consuming, and prone to errors. Traditional paper-based or semi-digital systems make it difficult to:
*   Track **room allocations** and occupancy in real-time.
*   Monitor **fee payments** and transparency.
*   Handle **student complaints** and maintenance requests efficiently.

This system provides an automated solution to streamline communication between students and administrators, ensuring better record-keeping and faster resolution of issues.

## How to Run the Code

### Prerequisites
*   **Java JDK 8 or higher** must be installed.
*   Check your version:
    ```bash
    java --version
    javac --version
    ```

### Execution Steps
1. **Prepare Files:** Ensure all `.java` files are inside a folder named `oopsproject/`.
2. **Compile:** Run the following command in your terminal:
   ```bash
   javac oopsproject/*.java
3. **Run:** java oopsproject.Main

## Sample Input / Output

1. Login screen
Welcome to Hostel Management System
Who are you?
1. Student
2. Warden
3. Exit System
Enter choice: 2

2. Warden login
Enter Warden Password: warden123

3. Register a student (Warden option 1)
1
Enter Student ID: 101
Enter Student Name: Yaksh
Student registered: Yaksh (ID: 101)
[File] Student data saved to students.txt

4. Allocate room (Warden option 2)
2
Room 1 allocated to Yaksh
[File] Student data saved to students.txt

5. View all rooms (Warden option 3)
3
--- Room Occupancy Status ---
Room No: 1 | Occupied: true
Room No: 2 | Occupied: false
Room No: 3 | Occupied: false
Room No: 4 | Occupied: false
Room No: 5 | Occupied: false

6. View all complaints (Warden option 4)
4
--- All Complaints ---
No complaints filed yet.

7. Update complaint status (Warden option 5)
5
Enter Ticket ID: 1
Enter status: Resolved
Ticket #1 updated to: Resolved

8. View fee status (Warden option 6)
6
--- Fee Status of All Students ---
Name: Yaksh | Fee paid: 0

9. View all students (Warden option 7)
7
--- All Registered Students ---
ID: 101 | Name: Yaksh | Room Allocated: true | Fee Paid: Rs.0

10. Search student by name (Warden option 8)
8
Enter student name: Yaksh
ID: 101 | Name: Yaksh | Room Allocated: true | Fee Paid: Rs.0

11. Warden logout (option 9)
9
Vinod has logged out successfully

12. Student login
1
Enter your Student ID: 101

13. Apply for room (Student option 1)
1
You already have a room allocated!
(or "Room 2 allocated to Yaksh" if not yet allocated)

14. File a complaint (Student option 2)
2
Describe your complaint: Light is not working
Complaint filed! Ticket #1 -> Light is not working
[File] Complaint data saved to complaints.txt

15. Pay fee (Student option 3)
3
Enter amount to pay (Rs.): 30000
Rs.5000 fee paid for Yaksh
[File] Student data saved to students.txt

16. View my fee status (Student option 4)
4
Name: Yaksh | Fee paid: 30000

17. Student logout (option 5)
5
Yaksh has logged out successfully

18. Exit system (option 3)
3
All data has been saved to files
Goodbye!

## Tools / Technologies Used
Language: Java (JDK 8+)

Core Concepts: OOP (Inheritance, Abstraction, Polymorphism, Encapsulation)

Collections: ArrayList for dynamic memory management.

Persistence: FileWriter & BufferedReader for file-based storage.

IO: Scanner for terminal-based user interaction.

Safety: try-catch blocks for robust error handling.
