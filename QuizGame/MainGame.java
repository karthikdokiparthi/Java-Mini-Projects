package QuizGame;

public class MainGame {
    public static void main(String[]args){
        printMain();
        allQuestion();
    }
    public static void printMain(){
        System.out.println("=========================================");
        System.out.println("         WELCOME JAVA QUIZ GAME");
        System.out.println("=========================================");
    }
    public static void allQuestion(){
        QuizDAO.getQuestions();
    }
}
