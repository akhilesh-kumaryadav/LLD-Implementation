package InterpreterPattern;

public class MultiplyNonTerminalExpression implements AbstractExpression {
    private final AbstractExpression rightExpression;
    private final AbstractExpression leftExpression;

    public MultiplyNonTerminalExpression(AbstractExpression left, AbstractExpression right) {
        this.leftExpression = left;
        this.rightExpression = right;
    }

    @Override
    public int interpret(Context context) {
        return leftExpression.interpret(context) * rightExpression.interpret(context);
    }
}