package learn.core1.ch06.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * An invocation handler that prints out the method name and parameters,
 * then invokes the original method.
 */
public class TraceHandler implements InvocationHandler {
    private Object target;

    /**
     * Constructs a TraceHandler.
     * @param target the implicit parameter of the method call
     */
    public TraceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        printMethodAndArguments(method, args);
        return method.invoke(target, args);
    }

    private void printMethodAndArguments(Method method, Object[] args) {
        System.out.print(target);
        System.out.print("." + method.getName() + "(");
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length - 1) System.out.print(", ");
            }
        }
        System.out.println(")");
    }
}
