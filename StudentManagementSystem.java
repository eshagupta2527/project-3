import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private int age;
    private String course;

    public Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void displayStudentInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
    }
}

public class StudentManagementSystem {
    private static Map<Integer, Student> studentRecords = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Remove Student");
            System.out.println("4. View Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    removeStudent();
                    break;
                case 4:
                    viewStudent();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid one.");
                    break;
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (studentRecords.containsKey(id)) {
            System.out.println("Error: Student with this ID already exists.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();

        scanner.nextLine(); // Consume newline
        System.out.print("Enter Course: ");
        String course = scanner.nextLine();

        Student student = new Student(id, name, age, course);
        studentRecords.put(id, student);
        System.out.println("Student added successfully!");
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();

        if (!studentRecords.containsKey(id)) {
            System.out.println("Error: Student not found.");
            return;
        }

        Student student = studentRecords.get(id);

        System.out.print("Enter new Name (or press Enter to keep the same): ");
        scanner.nextLine(); // Consume newline
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            student.setName(name);
        }

        System.out.print("Enter new Age (or press 0 to keep the same): ");
        int age = scanner.nextInt();
        if (age != 0) {
            student.setAge(age);
        }

        scanner.nextLine(); // Consume newline
        System.out.print("Enter new Course (or press Enter to keep the same): ");
        String course = scanner.nextLine();
        if (!course.isEmpty()) {
            student.setCourse(course);
        }

        System.out.println("Student updated successfully!");
    }

    private static void removeStudent() {
        System.out.print("Enter Student ID to remove: ");
        int id = scanner.nextInt();

        if (studentRecords.containsKey(id)) {
            studentRecords.remove(id);
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Error: Student not found.");
        }
    }

    private static void viewStudent() {
        System.out.print("Enter Student ID to view: ");
        int id = scanner.nextInt();

        if (studentRecords.containsKey(id)) {
            Student student = studentRecords.get(id);
            student.displayStudentInfo();
        } else {
            System.out.println("Error: Student not found.");
        }
    }
}