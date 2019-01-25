package learn.core1.ch08generics.reflection2;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Uses the generic reflection API to print out what it discovers about a given class.
 */
public class C080903GenericReflection {
    private Consumer<String> consumer;

    public C080903GenericReflection(Consumer<String> consumer) {
        this.consumer = consumer;
    }

    public static void main(String[] args) {
        String name = readClassName(args);
        StringBuilder builder = new StringBuilder();
        C080903GenericReflection genericReflection = new C080903GenericReflection(builder::append);
        try {
            genericReflection.printGenericInfo(name);
            System.out.println(builder.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void printGenericInfo(String name) throws ClassNotFoundException {
        Class<?> cl = Class.forName(name);
        printClass(cl);
        for (Method m : cl.getDeclaredMethods()) {
            printMethod(m);
        }
    }

    private void printClass(Class<?> cl) {
        consumer.accept(cl.toString());
        printTypes(cl.getTypeParameters(), "<", ", ", ">", true);
    }

    private void printTypes(Type[] types, String pre, String sep, String suf, boolean isDefinition) {
        if (pre.equals(" extends ") && containsObjectClass(types)) {
            return;
        }
        if (types.length > 0) {
            consumer.accept(pre);
            for (int i = 0; i < types.length; i++) {
                if (i > 0) {
                    consumer.accept(sep);
                }
                printType(types[i], isDefinition);
            }
            consumer.accept(suf);
        }
    }

    private void printType(Type type, boolean isDefinition) {
        if (type instanceof Class) {
            consumer.accept(((Class)type).getName());
        } else if (type instanceof TypeVariable) {
            TypeVariable t = (TypeVariable) type;
            consumer.accept(t.getName());
            if (isDefinition) {
                printTypes(t.getBounds(), " extends ", " & ", "", false);
            }
        }
        // TODO: WildcardType
    }

    private static boolean containsObjectClass(Type[] types) {
        return types.length == 1 && types[0] == Object.class;
    }

    private void printMethod(Method m) {
        String name = m.getName();
        consumer.accept(Modifier.toString(m.getModifiers()));
        consumer.accept(" ");
        printTypes(m.getTypeParameters(), "<", ", ", ">", true);
        // TODO: continue
    }

    private static String readClassName(String[] args) {
        String name;
        if (args.length > 0) {
            name = args[0];
        } else {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter class name (e.g. java.util.Collections): ");
            name = in.nextLine();
        }
        return name;
    }
}
