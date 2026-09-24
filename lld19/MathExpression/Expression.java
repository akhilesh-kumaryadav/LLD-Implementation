package MathExpression;

public class Expression implements ArithmeticExpression {
    ArithmeticExpression leftExpression;
    ArithmeticExpression rightExpression;
    OperationType operationType;

    public Expression(ArithmeticExpression leftExpression, ArithmeticExpression rightExpression,
            OperationType operationType) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operationType = operationType;
    }

    @Override
    public int evaluate() {
        int value = 0;

        switch (operationType) {
            case operationType.ADD:
                value = leftExpression.evaluate() + rightExpression.evaluate();
                break;
            case operationType.SUBTRACT:
                value = leftExpression.evaluate() - rightExpression.evaluate();
                break;
            case operationType.DIVIDE:
                value = leftExpression.evaluate() / rightExpression.evaluate();
                break;
            case operationType.MULTIPLY:
                value = leftExpression.evaluate() * rightExpression.evaluate();
                break;
        }

        System.out.println("Expression value is: " + value);
        return value;
    }
}