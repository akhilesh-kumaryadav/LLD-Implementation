package InterpreterPattern;

// Non terminal expression - represents an expression with a binary operator + or *
public class BinaryNonTerminalExpression implements AbstractExpression {
    AbstractExpression rightExpression;
    AbstractExpression leftExpression;
    char operator;

    public BinaryNonTerminalExpression(AbstractExpression left, AbstractExpression right, char operator) {
        this.leftExpression = left;
        this.rightExpression = right;
        this.operator = operator;
    }

    @Override
    public int interpret(Context context) {
        return switch (operator) {
            case '+' -> leftExpression.interpret(context) + rightExpression.interpret(context);
            case '*' -> leftExpression.interpret(context) * rightExpression.interpret(context);
            default -> 0;
        };
    }
}