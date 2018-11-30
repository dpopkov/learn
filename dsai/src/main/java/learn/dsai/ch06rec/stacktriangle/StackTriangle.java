package learn.dsai.ch06rec.stacktriangle;

import learn.dsai.ch06rec.StackT;

import static learn.dsai.ch06rec.stacktriangle.Address.*;

public class StackTriangle {
    private int number;
    private int answer;
    private StackT<ParamsE> stack = new StackT<>(100);
    private Address address;

    public int calculate(int n) {
        number = n;
        address = INITIAL_CALL;
        boolean done = false;
        while (!done) {
            done = step();
        }
        return answer;
    }

    private boolean step() {
        switch (address) {
            case INITIAL_CALL:
                stack.push(new ParamsE(number, RETURN_POINT));
                address = METHOD_ENTRY;
                break;
            case METHOD_ENTRY:
                if (stack.peek().number == 1) {
                    answer = 1;
                    address = METHOD_EXIT;
                } else {
                    address = RECURSIVE_CALL;
                }
                break;
            case RECURSIVE_CALL:
                int nextArgument = stack.peek().number - 1;
                stack.push(new ParamsE(nextArgument, CALCULATION));
                address = METHOD_ENTRY;
                break;
            case CALCULATION:
                answer = stack.peek().number + answer;
                address = METHOD_EXIT;
                break;
            case METHOD_EXIT:
                address = stack.pop().returnAddress;
                break;
            case RETURN_POINT:
                return true;
        }
        return false;
    }
}
