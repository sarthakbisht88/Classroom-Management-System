import java.util.*;

public class ClassroomManagementSystem {

    private static Scanner scanner = new Scanner(System.in);
    private static Map<Integer, Student> students = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nClassroom Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student Details");
            System.out.println("4. Remove Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudentDetails();
                    break;
                case 4:
                    removeStudent();
                    break;
                case 5:
                    System.out.println("Exiting the system...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    public static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        if (students.containsKey(id)) {
            System.out.println("Student with ID " + id + " already exists.");
            return;
        }

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        System.out.print("Enter Student Course: ");
        String course = scanner.nextLine();

        Student student = new Student(id, name, age, course);
        students.put(id, student);
        System.out.println("Student added successfully!");
    }

    public static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        System.out.println("\nList of Students:");
        for (Student student : students.values()) {
            System.out.println(student);
        }
    }

    public static void updateStudentDetails() {
        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        if (!students.containsKey(id)) {
            System.out.println("No student found with ID " + id);
            return;
        }

        Student student = students.get(id);
        System.out.println("Current details: " + student);

        System.out.print("Enter new Name (Leave blank to keep current): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            student.setName(name);
        }

        System.out.print("Enter new Age (Enter -1 to keep current): ");
        int age = scanner.nextInt();
        if (age != -1) {
            student.setAge(age);
        }

        scanner.nextLine(); // Consume newline left-over
        System.out.print("Enter new Course (Leave blank to keep current): ");
        String course = scanner.nextLine();
        if (!course.isEmpty()) {
            student.setCourse(course);
        }

        System.out.println("Student details updated successfully!");
    }

    public static void removeStudent() {
        System.out.print("Enter Student ID to remove: ");
        int id = scanner.nextInt();

        if (!students.containsKey(id)) {
            System.out.println("No student found with ID " + id);
            return;
        }

        students.remove(id);
        System.out.println("Student removed successfully!");
    }
}

