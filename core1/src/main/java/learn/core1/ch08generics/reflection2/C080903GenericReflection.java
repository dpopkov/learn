package learn.core1.ch08generics.reflection2;

import java.io.IOException;
import java.lang.reflect.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Uses the generic reflection API to print out what it discovers about a given class.
 */
public class C080903GenericReflection {
    private final Consumer<String> consumer;

    public C080903GenericReflection(Consumer<String> consumer) {
        this.consumer = consumer;
    }

    public static void main(String[] args) {
        try {
            String[] classNames = readClassNames(args);
            StringBuilder builder = new StringBuilder();
            C080903GenericReflection reflection = new C080903GenericReflection(builder::append);
            for (String name : classNames) {
                reflection.printGenericInfo(name);
                System.out.printf("Generic info for class: %s%n%s%n%n", name, builder.toString());
                builder.setLength(0);
            }
        } catch (ClassNotFoundException | IOException e) {
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
        print(cl.toString());
        printTypes(cl.getTypeParameters(), "<", ", ", ">", true);
        Type sc = cl.getGenericSuperclass();
        if (sc != null) {
            print(" extends ");
            printType(sc, false);
        }
        printTypes(cl.getGenericInterfaces(), " implements ", ", ", "", false);
        println();
    }

    private void printTypes(Type[] types, String pre, String sep, String suf, boolean isDefinition) {
        if (pre.equals(" extends ") && containsObjectClass(types)) {
            return;
        }
        if (types.length > 0) {
            print(pre);
            for (int i = 0; i < types.length; i++) {
                if (i > 0) {
                    print(sep);
                }
                printType(types[i], isDefinition);
            }
            print(suf);
        }
    }

    private void printType(Type type, boolean isDefinition) {
        if (type instanceof Class) {
            print(((Class)type).getName());
        } else if (type instanceof TypeVariable) {
            TypeVariable t = (TypeVariable) type;
            print(t.getName());
            if (isDefinition) {
                printTypes(t.getBounds(), " extends ", " & ", "", false);
            }
        } else if (type instanceof WildcardType) {
            WildcardType t = (WildcardType) type;
            print("?");
            printTypes(t.getUpperBounds(), " extends ", " & ", "", false);
            printTypes(t.getLowerBounds(), " extends ", " & ", "", false);
        } else if (type instanceof ParameterizedType) {
            ParameterizedType t = (ParameterizedType) type;
            Type owner = t.getOwnerType();
            if (owner != null) {
                printType(owner, false);
                print(".");
            }
            printType(t.getRawType(), false);
            printTypes(t.getActualTypeArguments(), "<", ", ", ">", false);
        } else if (type instanceof GenericArrayType) {
            GenericArrayType t = (GenericArrayType) type;
            printType(t.getGenericComponentType(), isDefinition);
            print("[]");
        }
    }

    private static boolean containsObjectClass(Type[] types) {
        return types.length == 1 && types[0] == Object.class;
    }

    private void printMethod(Method m) {
        String name = m.getName();
        print(Modifier.toString(m.getModifiers()));
        print(" ");
        printTypes(m.getTypeParameters(), "<", ", ", ">", true);

        printType(m.getGenericReturnType(), false);
        print(" ");
        print(name);
        print("(");
        printTypes(m.getGenericParameterTypes(), "", ", ", "", false);
        print(")");
        println();
    }

    private void print(String s) {
        consumer.accept(s);
    }

    private void println() {
        consumer.accept(System.lineSeparator());
    }

    private static String[] readClassNames(String[] args) throws IOException {
        String[] names;
        if (args.length == 2 && "--file".equals(args[0])) {
            Path p = Paths.get(args[1]);
            List<String> lines = Files.readAllLines(p);
            names = new String[lines.size()];
            names = lines.toArray(names);
        } else if (args.length == 1) {
            names = args;
        } else if (args.length == 0) {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter class names (e.g. java.util.Collections): ");
            String n = in.nextLine();
            names = new String[]{n};
        } else {
            System.out.println("Illegal number of arguments");
            names = new String[0];
        }
        return names;
    }
}
