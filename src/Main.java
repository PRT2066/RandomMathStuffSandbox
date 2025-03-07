import Stuff.CalculateStuff;
import Stuff.OperationModeEnums;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CalculateStuff calculate = new CalculateStuff();


        System.out.println("Welcome to Random Math Stuff Sandbox\n");

        calculate.setNum1(validateNumber(scan, "Please give me the first number: "));
        calculate.setNum2(validateNumber(scan, "Please give me the first number: "));

        System.out.println();
        printAnswers(calculate);
    }

    public static BigDecimal validateNumber(Scanner scan, String numberPrompt){
        BigDecimal number = null;
        while (number == null) {
            System.out.print(numberPrompt);
            try {
                number = scan.nextBigDecimal();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scan.next();
            }
        }
        return number;
    }

    public static void printAnswers(CalculateStuff calculate){
        OperationModeEnums[] operations = {
                OperationModeEnums.ADDITION,
                OperationModeEnums.SUBTRACTION,
                OperationModeEnums.MULTIPLY,
                OperationModeEnums.DIVISION
        };

        String[] operationSymbols = {"+", "-", "*", "divided by"};

        for (int i = 0; i < operations.length; i++) {
            BigDecimal answer = calculate.calculateNumbers(calculate.getNum1(), calculate.getNum2(), operations[i]);
            boolean isDivision = operations[i].getOperator().equalsIgnoreCase("D");

            if(!isDivision)
                System.out.println("The answer to " + calculate.getNum1() + " " + operationSymbols[i] + " " + calculate.getNum2() + " is " + answer);
            else if (answer != null)
                System.out.println("The answer to " + calculate.getNum1() + " " + operationSymbols[i] + " " + calculate.getNum2() + " is " + answer + "\n");
            else
                System.out.println("Division could not be calculated as you cannot use zeros. Answer is undefined.\n");
        }
    }

}