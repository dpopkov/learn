package learn.dsajg6e.ch08trees.exer;

class InfixExpression implements Expression {
    private final Expression first;
    private final Expression second;
    private final Operation operation;

    public InfixExpression(Expression first, Operation operation, Expression second) {
        this.first = first;
        this.second = second;
        this.operation = operation;
    }

    public String toStringPostfix() {
        return first + " " + second + " " + operation;
    }

    public Expression getFirst() {
        return first;
    }

    public Expression getSecond() {
        return second;
    }

    public Operation getOperation() {
        return operation;
    }

    @Override
    public String toString() {
        return toStringPostfix();
    }

    @Override
    public int value() {
        return operation.evaluate(first, second);
    }
}
