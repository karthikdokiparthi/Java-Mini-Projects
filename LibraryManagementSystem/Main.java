package LibraryManagementSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static void printMenu() {
        System.out.println("==== Library Management System ====");
        System.out.println("1. Add Book");
        System.out.println("2. View Books");
        System.out.println("3. Add Member");
        System.out.println("4. View Members");
        System.out.println("5. Issue Book");
        System.out.println("6. Return Book");
        System.out.println("7. Add New Admin");
        System.out.println("8. View Admin Data");
        System.out.println("9. View Issued Books Details");
        System.out.println("10. Exit");
        System.out.print("Enter your choice:");
    }

    private static ArrayList<Member> membersData = new ArrayList<>();
    //private static ArrayList<Book> booksData=new ArrayList<>();
    private static ArrayList<Issue> issueBooksData = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("--------- LIBRARY MANAGEMENT SYSTEM LOGIN AUTHENTICATION ---------");
            System.out.println("1. Login as Library Admin");
            System.out.println("2. Login as User");
            System.out.println("3. Exit");
            System.out.print("Choice your login : ");
            int loginKey = scanner.nextInt();
            switch (loginKey) {
                case 1:
                    if (loginAdmin()) {
                        boolean isRunning = true;
                        while (isRunning) {
                            printMenu();
                            int choice = scanner.nextInt();
                            switch (choice) {
                                case 1:
                                    addBook();
                                    break;
                                case 2:
                                    viewBooks();
                                    break;
                                case 3:
                                    addMember();
                                    break;
                                case 4:
                                    viewMembers();
                                    break;
                                case 5:
                                    issueBooks();
                                    break;
                                case 6:
                                    returnBooks();
                                    break;
                                case 7:
                                    addNewAdmin();
                                    break;
                                case 8:
                                    viewAdminData();
                                    break;

                                case 9:
                                    issuedBooks();
                                    break;
                                case 10:
                                    isRunning = false; // Exits the while loop
                                    break;
                                default:
                                    System.out.println("Please Enter a Valid number");
                                    break;
                            }
                        }
                    }
                    break;

                case 2:
                    boolean isRun = true;
                    while (isRun) {
                        System.out.println("1. View Books");
                        System.out.println("2. View Members");
                        System.out.println("3. Issue Book");
                        System.out.println("4. View Issued Books Details");
                        System.out.println("5. Exit");
                        System.out.print("Enter your choice:");
                        int input = scanner.nextInt();
                        switch (input) {
                            case 1:
                                viewBooks();
                                break;
                            case 2:
                                viewMembers();
                                break;
                            case 3:
                                issueBooks();
                                break;
                            case 4:
                                issuedBooks();
                                break;
                            case 5:
                                isRun = false;
                                break;
                            default:
                                System.out.println("Please Enter a Valid number");
                                break;
                        }
                    }
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid login key");
                    break;
            }
        }

    }

    public static void viewBooks() {
//        for (Book b : booksData) {
//            System.out.println(b);
//        }
        LibraryDAO.viewBooks();
    }

    public static void viewMembers() {
//        for(Member m: membersData){
//            System.out.println(m);
//        }
        LibraryDAO.viewMembers();
    }

    public static void addMember() {
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.next();
        System.out.print("Enter Phone number: ");
        long phoneNumber = scanner.nextLong();

        LibraryDAO.insertMembers(new Member(id, name, phoneNumber));
    }

    public static void addBook() {
        Scanner scanner = new Scanner(System.in); // Make sure scanner is defined

        System.out.print("Enter Book Id: ");
        String bookId = scanner.nextLine();

        System.out.print("Enter Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Author: ");
        String author = scanner.nextLine();

        System.out.print("Enter Publisher: ");
        String publisher = scanner.nextLine();

        System.out.print("Enter Year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline

        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline if needed

        Book book = new Book(bookId, title, author, publisher, year, genre, quantity);
        LibraryDAO.insertBooks(book);
    }

    public static void addNewAdmin() {
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter UserName: ");
        String username = scanner.next();
        System.out.print("Enter Password: ");
        String password = scanner.next();
        LibraryDAO.createAdminAccount(new AdminAccess(id, username, password));
        System.out.println("New Admin Registration Completed");
    }

    public static void viewAdminData() {
        LibraryDAO.getAllAdmins();
    }

    public static boolean loginAdmin() {
        System.out.print("Enter UserName: ");
        String userName = scanner.next();
        System.out.print("Enter Password: ");
        String password = scanner.next();

        AdminAccess admin = (new AdminAccess(0, userName, password));
        boolean isAuthenticated = LibraryDAO.getAdminAccess(admin);

        if (isAuthenticated) {
            System.out.println("Login Successful. Welcome, Admin!");
            return true;
        } else {
            System.out.println("Login Failed. Invalid credentials.");
            return false;
        }
    }

    public static void issueBooks() {
        System.out.print("Enter Member Id: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Book Id: ");
        String bookId = scanner.nextLine();

        boolean issued = LibraryDAO.setIssueBooks(new Member(memberId, null, null), new Book(bookId, null, null, null, 0, null, 0));
        if (issued) {
            System.out.println("Book issued successfully.");
        } else {
            System.out.println("Book could not be issued. Either member or book not found or book is out of stock.");
        }
    }

    public static void returnBooks() {
        System.out.print("Enter Member ID: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Book ID: ");
        String bookId = scanner.next();

        LibraryDAO.getReturnBooks(new Member(memberId, null, null), new Book(bookId, null, null, null, 0, null, 0));
    }

    public static void issuedBooks(){
        LibraryDAO.getIssuedBooks();
    }
}