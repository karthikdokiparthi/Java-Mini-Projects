package LibraryManagementSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static void printMenu(){
        System.out.println("==== Library Management System ====");
        System.out.println("1. Add Book");
        System.out.println("2. View Books");
        System.out.println("3. Add Member");
        System.out.println("4. View Members");
        System.out.println("5. Issue Book");
        System.out.println("6. Return Book");
        System.out.println("7. Add New Admin");
        System.out.println("8. View Admin Data");
        System.out.println("9. Exit");
        System.out.println("Enter your choice:");
    }

    private static ArrayList<Member> membersData=new ArrayList<>();
    //private static ArrayList<Book> booksData=new ArrayList<>();
    private static ArrayList<Issue> issueBooksData=new ArrayList<>();
    private static Scanner scanner=new Scanner(System.in);
    public static void main(String[]args){

        //predefined books data
//        booksData.add(new Book("B001", "The Alchemist", "Paulo Coelho", "HarperCollins", 1988, "Fiction", 5));
//        booksData.add(new Book("B002", "Clean Code", "Robert C. Martin", "Prentice Hall", 2008, "Programming", 3));
//        booksData.add(new Book("B003", "To Kill a Mockingbird", "Harper Lee", "J.B. Lippincott", 1960, "Classic", 4));
//        booksData.add(new Book("B004", "Think and Grow Rich", "Napoleon Hill", "The Ralston Society", 1937, "Self-Help", 2));
//        booksData.add(new Book("B005", "Head First Java", "Kathy Sierra & Bert Bates", "O'Reilly Media", 2005, "Programming", 6));
//        booksData.add(new Book("B006", "1984", "George Orwell", "Secker & Warburg", 1949, "Dystopian", 3));
//        booksData.add(new Book("B007", "The Pragmatic Programmer", "Andrew Hunt & David Thomas", "Addison-Wesley", 1999, "Programming", 4));
//        booksData.add(new Book("B008", "The Great Gatsby", "F. Scott Fitzgerald", "Scribner", 1925, "Classic", 2));
//        booksData.add(new Book("B009", "Introduction to Algorithms", "Cormen et al.", "MIT Press", 1990, "Academic", 1));
//        booksData.add(new Book("B010", "The Power of Habit", "Charles Duhigg", "Random House", 2012, "Psychology", 5));

//        //predefined members data
//        membersData.add(new Member(1,"Karthik",8080808080l));
//        membersData.add(new Member(2,"Pavan",8080808081l));
//        membersData.add(new Member(3,"Sai Manikanta",8080808082l));
//        membersData.add(new Member(4,"Sriram",8080808083l));
//        membersData.add(new Member(5,"Ramu",8080808084l));

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
                                    // issuedBooks();
                                    break;
                                case 6:
                                    // returnBooks();
                                    break;
                                case 7:
                                    addNewAdmin();
                                    break;
                                case 8:
                                    viewAdminData();
                                    break;
                                case 9:
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
                        System.out.println("4. Exit");
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
                                break;
                            case 4:
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

    public static void viewMembers(){
//        for(Member m: membersData){
//            System.out.println(m);
//        }
        LibraryDAO.viewMembers();
    }

    public static void addMember(){
        System.out.print("Enter id: ");
        int id=scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name=scanner.next();
        System.out.print("Enter Phone number: ");
        long phoneNumber=scanner.nextLong();

        LibraryDAO.insertMembers(new Member(id,name,phoneNumber));
    }

    public static void addBook(){
        System.out.print("Enter Book Id: ");
        String bookId=scanner.next();
        System.out.print("Enter Title: ");
        String title=scanner.next();
        System.out.print("Enter Author: ");
        String author=scanner.next();
        System.out.print("Enter Publisher: ");
        String publisher=scanner.next();
        System.out.print("Enter Year: ");
        int year= scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter genre: ");
        String genre= scanner.next();
        System.out.print("Enter quantity: ");
        int quantity=scanner.nextInt();

        Book book=(new Book(bookId,title,author,publisher,year,genre,quantity));
        LibraryDAO.insertBooks(book);
    }

//    public static void issuedBooks(){
//        System.out.print("Enter Member Id: ");
//        int memberId=scanner.nextInt();
//        scanner.nextLine();
//        System.out.print("Enter Book Id: ");
//        String bookId=scanner.next();
//
//        Member member=null;
//        for(Member m:membersData){
//            if(m.getId()==memberId){
//                member=m;
//                break;
//            }
//        }
//
//        if(member==null){
//            System.out.println("Member not found");
//            return;
//        }
//        Book book=null;
//        for(Book b:booksData){
//            if(b.getBookId().equals(bookId)){
//                book=b;
//                break;
//            }
//        }
//        if(book==null){
//            System.out.println("Book not Found");
//            return;
//        }
//
//        if(book.getQuantity()<=0){
//            System.out.println("Book is currently not available.");
//            return;
//        }
//
//        book.setQuantity(book.getQuantity()-1);
//        Issue issue=new Issue();
//        issue.setMemberId(memberId);
//        issue.setBookId(bookId);
//        issue.setIssueDate(LocalDate.now());
//        issue.setReturnDate(null);
//
//        issueBooksData.add(issue);
//        //issueBooksData.add(new Issue(memberId,bookId,LocalDate.now(),LocalDate.now().plusDays(14)));
//
//        System.out.println("Book issued successfully to " + member.getName());
//    }
//    public static void returnBooks(){
//        System.out.print("Enter Member ID: ");
//        int memberId=scanner.nextInt();
//        scanner.nextLine();
//        System.out.print("Enter Book ID: ");
//        String bookId=scanner.next();
//
//        boolean found=false;
//        for(Issue issue:issueBooksData){
//            if(issue.getMemberId()==memberId && issue.getBookId().equals(bookId)&& issue.getReturnDate()==null) {
//                issue.setReturnDate(LocalDate.now());
//                System.out.println("Book return Successfully");
//                found = true;
//                break;
//            }
//        }
//        if(!found){
//            System.out.println("No matching issued book found (either already returned or invalid details).");
//        }
//    }
    public static void addNewAdmin(){
        System.out.print("Enter id: ");
        int id=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter UserName: ");
        String username=scanner.next();
        System.out.println("Enter Password: ");
        String password=scanner.next();
        LibraryDAO.createAdminAccount(new AdminAccess(id,username,password));
        System.out.println("New Admin Registration Completed");
    }

    public static void viewAdminData(){
        LibraryDAO.getAllAdmins();
    }

    public static boolean loginAdmin(){
        System.out.print("Enter UserName: ");
        String userName=scanner.next();
        System.out.print("Enter Password: ");
        String password=scanner.next();

        AdminAccess admin=(new AdminAccess(0,userName,password));
        boolean isAuthenticated=LibraryDAO.getAdminAccess(admin);

        if (isAuthenticated) {
            System.out.println("Login Successful. Welcome, Admin!");
            return true;
        } else {
            System.out.println("Login Failed. Invalid credentials.");
            return false;
        }
    }
}
