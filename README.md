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
Use the Warden login (Option 2) first to register students and allocate rooms before logging in as a Student.

Warden Login: Enter choice 2 → Password: warden123.

Registration: Input Student ID 101 and Name Alice.

Room Status: Option 3 displays Room No: 1 | Occupied: true.

Complaint Filing: Student enters description: Water leakage in bathroom.

Fee Status: Displays Name: Alice | Fee paid: 5000.

Persistence: All data is saved to students.txt and complaints.txt automatically.

🛠️ 6. Tools / Technologies Used
Language: Java (JDK 8+)

Core Concepts: OOP (Inheritance, Abstraction, Polymorphism, Encapsulation)

Collections: ArrayList for dynamic memory management.

Persistence: FileWriter & BufferedReader for file-based storage.

IO: Scanner for terminal-based user interaction.

Safety: try-catch blocks for robust error handling.
