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
                updateStudent();
                break;
            case 5:
                deleteStudent();
                break;
            case 6:
                System.exit(0);
            default:
                System.out.println("Invalid Key enter");
        }
    }
    public static void menu(){
        System.out.println("1. Add Student");
        System.out.println("2. View all students");
        System.out.println("3. Search by roll number");
        System.out.println("4. Update students");
        System.out.println("5. Delete student");
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
        System.out.print("Enter Roll NO: ");
        int id=scanner.nextInt();
        StudentDAO.deleteStudent(new Students(id,null,null,null));
    }

}
