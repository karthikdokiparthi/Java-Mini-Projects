import java.util.Scanner;

public class Calculator {
    public static int add(int a, int b) {
        return a + b;
    }

    public static int sub(int a, int b) {
        return a - b;
    }

    public static int mul(int a, int b) {
        return a * b;
    }

    public static double div(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a value : ");
        int a = scanner.nextInt();

        System.out.print("Enter a value : ");
        int b = scanner.nextInt();

        System.out.print("Operator : ");
        String symbol = scanner.next();

        double result = 0;
        switch (symbol) {
            case "+":
                result = add(a, b);
                break;
            case "-":
                result = sub(a, b);
                break;
            case "*":
                result = mul(a, b);
                break;
            case "/":
                try {
                    result = div(a, b);
                } catch (Exception e) {
                    System.out.println(e);
                }

                break;
            default:
                System.out.println("Please check the operation");
                break;
        }

        System.out.println(result);

    }
}