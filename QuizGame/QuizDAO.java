package QuizGame;

import java.sql.*;
import java.util.Scanner;

public class QuizDAO {


    public static final String url="jdbc:postgresql://localhost:5432/DemoDataBase";
    public static  final String username="postgres";
    public static final String password="K@rthik";
    static Scanner scanner=new Scanner(System.in);
    static {
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
    public static void getQuestionsByCategory(String category){
        int score = 0;
        int numberOfQuestion = 0;
        String sql = "SELECT question_no, question, option_a, option_b, option_c, option_d, correct_answer FROM quizquestions WHERE category = ?";

        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            // Set the category value here:
            pstmt.setString(1, category); // or pass "java" as a method argument if you want to make it dynamic

            try (ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {
                    int questionNO = resultSet.getInt("question_no");
                    String question = resultSet.getString("question");
                    String optionA = resultSet.getString("option_a");
                    String optionB = resultSet.getString("option_b");
                    String optionC = resultSet.getString("option_c");
                    String optionD = resultSet.getString("option_d");
                    String correctAnswer = resultSet.getString("correct_answer");

                    System.out.println("Question " + questionNO + ":");
                    System.out.println(question + "\n");
                    System.out.println("A. " + optionA);
                    System.out.println("B. " + optionB);
                    System.out.println("C. " + optionC);
                    System.out.println("D. " + optionD);
                    System.out.print("Enter your answer (A/B/C/D): ");
                    String userAnswer = scanner.nextLine().trim().toUpperCase();
                    while (!userAnswer.matches("[ABCD]")) {
                        System.out.print("Invalid input. Please enter A, B, C, or D: ");
                        userAnswer = scanner.nextLine().trim().toUpperCase();
                    }

                    if (correctAnswer.equalsIgnoreCase(userAnswer)) {
                        System.out.println("✅ Correct!\n");
                        score++;
                    } else {
                        System.out.println("❌ Incorrect! The correct answer is " + correctAnswer + ".\n");
                    }
                    numberOfQuestion++;
                }
            }

            System.out.println("-----------------------------------------");
            System.out.println("         \uD83C\uDF89 QUIZ COMPLETED \uD83C\uDF89");
            System.out.println("-----------------------------------------");
            double percentage = (score * 100.0) / numberOfQuestion;
            System.out.printf("Your final score: %d out of %d (%.2f%%)\n", score, numberOfQuestion, percentage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
