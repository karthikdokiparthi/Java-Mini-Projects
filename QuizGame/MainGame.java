package QuizGame;

import java.util.Scanner;

public class MainGame {
    static Scanner scanner=new Scanner(System.in);

    public static void main(String[]args){
        System.out.println("=========================================");
        System.out.println("         WELCOME JAVA QUIZ GAME");
        System.out.println("=========================================");
        System.out.print("Enter your name: ");
        String name=scanner.nextLine();
        System.out.println();
        System.out.println("Hello, "+name+"! Let's begin the quiz.");
        System.out.println("---------------------------------------");
        printMenu();
        printSwitch();
        thanksMessage(name);
    }
    public static void printMenu(){
        System.out.println("1. Java Questions");
        System.out.println("2. Spring Boot Questions");
        System.out.println("3. React Questions");
        System.out.println("4. JavaScript Questions");
        System.out.println("5. HTML Questions");
        System.out.println("6. CSS Questions");
        System.out.println("7. SQL Questions");
        System.out.println("8. Exit");
        System.out.print("Choose Above Category: ");
    }
    public static void printSwitch(){
        int choice=scanner.nextInt();
        switch (choice) {
            case 1:
                QuizDAO.getQuestionsByCategory("Java");
                break;
            case 2:
                QuizDAO.getQuestionsByCategory("Spring Boot");
                //spring-boot
                break;
            case 3:
                QuizDAO.getQuestionsByCategory("React");
                //react
                break;
            case 4:
                QuizDAO.getQuestionsByCategory("JavaScript");
                //javascript
                break;
            case 5:
                QuizDAO.getQuestionsByCategory("HTML");
                //HTML
                break;
            case 6:
                QuizDAO.getQuestionsByCategory("CSS");
                //CSS
                break;
            case 7:
                QuizDAO.getQuestionsByCategory("SQL");
                //SQL
                break;
            case 8:
                System.exit(0);
            default:
                System.out.println("Invalid key entered");
                break;
        }
    }
    public static void thanksMessage(String name){
        System.out.println("Thank you, "+name+"!");
    }

}
