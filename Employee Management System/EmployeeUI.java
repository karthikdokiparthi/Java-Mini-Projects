import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeUI {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Employee> empData = new ArrayList<>();

    public static void main(String[] args) {

        // Predefined Employee Data
        empData.add(new Employee(101, "Karthik", 40000));
        empData.add(new Employee(102, "Pavan", 35000));
        empData.add(new Employee(103, "Sai Manikanta", 45000));
        empData.add(new Employee(104, "Sriram", 40000));
        empData.add(new Employee(105, "Ramu", 45000));

        System.out.println("--------- EMPLOYEE MANAGEMENT SYSTEM ---------");
        System.out.println("1. Login as Admin");
        System.out.println("2. Login as Employee");
        System.out.print("Choice your login : ");
        int loginKey = scanner.nextInt();

        // Authentication
        String adminUserName = "admin123";
        int adminPassword = 12345678;

        switch (loginKey) {
            case 1:
                System.out.print("Enter admin-Id : ");
                String adminId = scanner.next();
                System.out.print("Enter Admin-Password : ");
                int adminpw = scanner.nextInt();
                while (adminId.equals(adminUserName) && adminpw == adminPassword) {
                    viewAdminAccess();
                    System.out.print("Enter your choice: ");
                    int adminInput = scanner.nextInt();
                    switch (adminInput) {
                        case 1:
                            addEmployee();
                            break;
                        case 2:
                            employeeDetails(empData);
                            break;
                        case 3:
                            updateEmployee();
                            break;
                        case 4:
                            deleteEmploye();
                            break;
                        case 5:
                            System.exit(0);
                        default:
                            System.out.println("Invalid key entered");
                            break;
                    }
                }
                System.out.println("Admin Id or password is invalid.");
                break;
            case 2:
                System.out.print("Enter Employee Id: ");
                int empId = scanner.nextInt();
                for (Employee emp : empData) {
                    while (empId == emp.getEmployeeId()) {
                        viewEmployeeAccess();
                        System.out.print("Enter your choice: ");
                        int empInput = scanner.nextInt();
                        switch (empInput) {
                            case 1:
                                employeeDetails(empData);
                                break;
                            case 2:
                                updateEmployee();
                                break;
                            case 3:
                                System.exit(0);
                            default:
                                System.out.println("Invalid key Entered");
                                break;
                        }
                    }
                }
                System.out.println("Employee ID not matched.");
                break;
            default:
                System.out.println("Invalid key entered");
                break;
        }
    }

    public static void viewAdminAccess() {
        System.out.println("----------- Admin Access -----------");
        System.out.println("1. Add new Employee");
        System.out.println("2. View Employee details");
        System.out.println("3. Update Employee details");
        System.out.println("4. Delete Employee details");
        System.out.println("5. Exit");
        // Add functionality here
    }

    public static void viewEmployeeAccess() {
        System.out.println("----------- Employee Access -----------");
        System.out.println("1. View Employee details");
        System.out.println("2. Update Employee details");
        System.out.println("3. Exit");
        // Add functionality here
    }

    public static void employeeDetails(ArrayList<Employee> empList) {
        System.out.println("Employee Records:");
        for (Employee emp : empList) {
            System.out.println(emp);
        }
    }

    public static void addEmployee() {
        System.out.println("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Name: ");
        String name = scanner.next();
        System.out.println("Enter Salary: ");
        int sal = scanner.nextInt();

        empData.add(new Employee(id, name, sal));
        System.out.println("Employee added successfully.");
    }

    public static void updateEmployee() {
        System.out.println("Enter employee ID to update: ");
        int eId = scanner.nextInt();
        for (Employee emp : empData) {
            if (emp.getEmployeeId() == eId) {
                scanner.nextLine();
                System.out.println("Enter new Name: ");
                emp.setEmployeeName(scanner.nextLine());
                System.out.println("Enter new Salary: ");
                emp.setEmployeeSalary(scanner.nextInt());
                System.out.println("Employee updated.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void deleteEmploye() {
        System.out.println("Enter Employee Id: ");
        int empId = scanner.nextInt();
        for (Employee emp : empData) {
            if (empId == emp.getEmployeeId()) {
                empData.remove(emp);
                System.out.println("Employee deleted.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }
}
