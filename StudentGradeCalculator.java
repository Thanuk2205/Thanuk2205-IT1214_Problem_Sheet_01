public class StudentGradeCalculator {

    // Student class
    static class Student {
        private String name;
        private int exam1;
        private int exam2;
        private int exam3;

        // Constructor with input validation
        public Student(String name, int exam1, int exam2, int exam3) {
            this.name = name;
            setExam1(exam1);
            setExam2(exam2);
            setExam3(exam3);
        }

        // Setters with validation
        public void setExam1(int exam1) {
            if (exam1 < 0 || exam1 > 100) {
                throw new IllegalArgumentException("Exam scores must be between 0 and 100.");
            }
            this.exam1 = exam1;
        }

        public void setExam2(int exam2) {
            if (exam2 < 0 || exam2 > 100) {
                throw new IllegalArgumentException("Exam scores must be between 0 and 100.");
            }
            this.exam2 = exam2;
        }

        public void setExam3(int exam3) {
            if (exam3 < 0 || exam3 > 100) {
                throw new IllegalArgumentException("Exam scores must be between 0 and 100.");
            }
            this.exam3 = exam3;
        }

        // Getters
        public String getName() {
            return name;
        }

        public int getExam1() {
            return exam1;
        }

        public int getExam2() {
            return exam2;
        }

        public int getExam3() {
            return exam3;
        }

        // Calculate average
        public double calculateAverage() {
            return (exam1 + exam2 + exam3) / 3.0;
        }
    }

    // Main method
    public static void main(String[] args) {
        try {
            // Attempt to create student with one invalid score
            Student student = new Student("John", 75, 110, 90);
            // If successful, print details
            double average = student.calculateAverage();
            System.out.printf("Student: %s%nAverage Score: %.2f%n", student.getName(), average);
        } catch (IllegalArgumentException e) {
            // Handle invalid score
            System.out.println("Error: " + e.getMessage());
        }
    }
}
