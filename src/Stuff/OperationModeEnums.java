package Stuff;

public enum OperationModeEnums {

    ADDITION("A"),
    SUBTRACTION("S"),
    MULTIPLY("M"),
    DIVISION("D");

    private final String operator;

    OperationModeEnums(String operator) {
        this.operator = operator;
    }

    public String getOperator(){
        return operator;
    }

}
