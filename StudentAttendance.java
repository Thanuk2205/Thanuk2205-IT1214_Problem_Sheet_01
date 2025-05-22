// Student.java
class Student {
    private int studentId;
    private String name;
    private int daysAttended;

    // Constructor
    public Student(int studentId, String name, int daysAttended) {
        this.studentId = studentId;
        this.name = name;
        this.daysAttended = daysAttended;
    }

    // Getters
    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getDaysAttended() {
        return daysAttended;
    }

    // Setters
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDaysAttended(int daysAttended) {
        this.daysAttended = daysAttended;
    }

    // ToString method for displaying student details
    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Name: " + name + ", Days Attended: " + daysAttended;
    }
}

// Classroom.java
class Classroom {
    private Student[] students;
    private int count;

    public Classroom() {
        students = new Student[10]; // Maximum capacity of 10
        count = 0;
    }

    // Method to add a student
    public void addStudent(Student student) {
        if (count < students.length) {
            students[count] = student;
            count++;
        } else {
            System.out.println("Cannot add more students, classroom is full.");
        }
    }

    // Method to update attendance
    public void updateAttendance(int studentId, int newDaysAttended) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (students[i].getStudentId() == studentId) {
                students[i].setDaysAttended(newDaysAttended);
                found = true;
                System.out.println("Attendance updated for student ID: " + studentId);
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }

    // Method to display all students
    public void displayAllStudents() {
        System.out.println("\n--- Student Details ---");
        for (int i = 0; i < count; i++) {
            System.out.println(students[i]);
        }
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        Classroom classroom = new Classroom();

        // Adding students
        classroom.addStudent(new Student(101, "Alice Smith", 12));
        classroom.addStudent(new Student(102, "Bob Jones", 15));
        classroom.addStudent(new Student(103, "Carol Lee", 10));

        // Update Bob Jones's attendance to 16
        classroom.updateAttendance(102, 16);

        // Attempt to update a non-existent student
        classroom.updateAttendance(104, 5);

        // Display all student details
        classroom.displayAllStudents();
    }
}
