package Student_Management_System;

import java.util.Scanner;

public class StudentMain {
    public static Scanner scanner=new Scanner(System.in);
    public static void main(String[]args){

        menu();

        int choice=scanner.nextInt();
        switch (choice){
            case 1:
                addStudent();
                break;
            case 2:
                viewStudents();
                break;
            case 3:
                searchByRollNumber();
                break;
            case 4:
                searchByDepartment();
                break;
            case 5:
                updateStudent();
                break;
            case 6:
                deleteStudent();
                break;
            case 7:
                System.exit(0);
            default:
                System.out.println("Invalid Key enter");
        }
    }



    public static void menu(){
        System.out.println("1. Add Student");
        System.out.println("2. View all students");
        System.out.println("3. Search by roll number");
        System.out.println("4. Search by Department");
        System.out.println("5. Update students");
        System.out.println("6. Delete student");
        System.out.println("7. Exit");
    }

    public static void addStudent() {
        System.out.print("Enter Roll No: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        System.out.print("Enter Email ID: ");
        String emailId = scanner.nextLine();

        if (emailId.isEmpty()) {
            System.out.println("❌ Email cannot be empty!");
            return;
        }

        StudentDAO.addStudent(new Students(id, name, department, emailId));
    }


    public static void viewStudents(){
        StudentDAO.viewAllStudents();
    }

    public static void searchByRollNumber(){
        System.out.print("Enter RollNumber: ");
        int rollNo=scanner.nextInt();
        StudentDAO.searchByRollNO(new Students(rollNo,null,null,null));
    }

    public static void updateStudent(){
        System.out.print("Enter Roll No: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        System.out.print("Enter Email ID: ");
        String emailId = scanner.nextLine();

        StudentDAO.getUpdateStudent(new Students(id,name,department,emailId));
    }

    public static void deleteStudent(){
        System.out.print("Enter Roll NO to search: ");
        int id=scanner.nextInt();
        StudentDAO.deleteStudent(id);
    }

    private static void searchByDepartment() {
        scanner.nextLine();
        System.out.print("Enter department to search: ");
        String department=scanner.nextLine();
        StudentDAO.searchByDepartment(department);
    }
}
