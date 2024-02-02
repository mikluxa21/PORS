/*
 * Created: Teterev Nikolai Valerevich 9363
 * Task: T4
 * Date: 1.02,2024
 * Version: 1
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        try {
            Calculator calculator = (Calculator) Naming.lookup("//localhost/Calculator");

            BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the expression: ");
            String expression = consoleIn.readLine();

            String[] parts = expression.split(" ");
            int num1 = Integer.parseInt(parts[0]);
            int num2 = Integer.parseInt(parts[2]);
            String operator = parts[1];

            int result = 0;
            switch (operator) {
                case "+":
                    result = calculator.add(num1, num2);
                    break;
                case "-":
                    result = calculator.subtract(num1, num2);
                    break;
                case "*":
                    result = calculator.multiply(num1, num2);
                    break;
                case "/":
                    result = calculator.divide(num1, num2);
                    break;
                default:
                    throw new IllegalArgumentException("Unsupirted operation");
            }

            System.out.println("Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

