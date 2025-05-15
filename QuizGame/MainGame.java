package QuizGame;

import java.util.Scanner;

public class MainGame {
    public static Scanner scanner=new Scanner(System.in);
    public static void main(String[]args){
        printMain();

        allQuestion();
    }
    public static void printMain(){
        System.out.println("=========================================");
        System.out.println("         WELCOME JAVA QUIZ GAME");
        System.out.println("=========================================");
        System.out.print("Enter your name: ");
        String name=scanner.nextLine();
        System.out.println();
        System.out.println("Hello, "+name+"! Let's begin the quiz.");
        System.out.println("---------------------------------------");
    }
    public static void allQuestion(){
        QuizDAO.getQuestions();
    }
}
