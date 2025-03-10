package Stuff;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculateStuff {

    // Variables
    private BigDecimal num1 = BigDecimal.ZERO;
    private BigDecimal num2 = BigDecimal.ZERO;


    public BigDecimal calculateNumbers(BigDecimal num1, BigDecimal num2, OperationModeEnums operator) {
        if (num1 == null || num2 == null) {
            System.out.println("One of the numbers you gave me is null. Cannot calculate.");
            return null;
        }

        switch (operator) {
            case ADDITION:
                return num1.add(num2);
            case SUBTRACTION:
                return num1.subtract(num2);
            case MULTIPLY:
                return num1.multiply(num2);
            case DIVISION:
                if (num1.equals(BigDecimal.ZERO) || num2.equals(BigDecimal.ZERO)) {
                    System.out.println("Cannot divide by zero.");
                    return null;
                }
                try {
                    return num1.divide(num2, RoundingMode.UNNECESSARY);
                } catch (ArithmeticException e) {
                    return num1.divide(num2, 3, RoundingMode.HALF_UP);
                }
            default:
                System.out.println("Unsupported operation.");
                return null;
        }
    }

    public BigDecimal getNum1() {
        return num1;
    }

    public void setNum1(BigDecimal num1) {
        this.num1 = num1;
    }

    public BigDecimal getNum2() {
        return num2;
    }

    public void setNum2(BigDecimal num2) {
        this.num2 = num2;
    }
}
