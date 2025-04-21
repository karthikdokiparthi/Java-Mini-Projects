package Random_Number_Guessing_Game;

import java.util.Random;
import java.util.Scanner;

public class RandomNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int randResult = rand.nextInt(100);
        System.out.println("---Game Started---");

        int i = 5;
        while (i > 0) {
            System.out.println("You have " + i + " Chances ");
            System.out.print("Guess the Number : ");
            int num = scanner.nextInt();
            if (num == randResult) {
                System.out.println(" YOU WIN THE GAME! ");
                break;
            } else if (num > randResult) {
                System.out.println("too high ...");
            } else if (num < randResult && i >= 2) {
                System.out.println("too low ...");
            } else {
                System.out.println(" GAME OVER ");
            }
            i--;
        }
    }
}
