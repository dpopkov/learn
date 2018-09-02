package learn.core1.ch05;

import java.lang.reflect.*;
import java.util.Scanner;

/**
 * Uses reflection to print all features of a class.
 */
public class ReflectionUsage {

    private static final String INDENT = "   ";

    public static void main(String[] args) {
        String name;
        if (args.length > 0) {
            name = args[0];
        } else {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter class name (e.g. java.util.Data): ");
            name = in.next();
        }

        try {
            Class cl = Class.forName(name);
            Class superClass = cl.getSuperclass();
            printModifiers(cl.getModifiers());
            System.out.print("class " + name);
            if (superClass != null && superClass != Object.class) {
                System.out.print(" extends " + superClass.getName());
            }
            System.out.println("\n{");

            printConstructors(cl);
            System.out.println();

            printMethods(cl);
            System.out.println();

            printFields(cl);
            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints all constructors of a class.
     * @param cl a class
     */
    private static void printConstructors(Class cl) {
        for (Constructor constructor : cl.getDeclaredConstructors()) {
            System.out.print(INDENT);

            printModifiers(constructor.getModifiers());
            System.out.print(constructor.getName() + "(");

            printParameterTypes(constructor);
            System.out.println(");");
        }
    }

    /**
     * Prints all methods of a class.
     * @param cl a class
     */
    private static void printMethods(Class cl) {
        for (Method method : cl.getDeclaredMethods()) {
            System.out.print(INDENT);

            printModifiers(method.getModifiers());
            System.out.print(method.getReturnType().getName() + " " + method.getName() + "(");

            printParameterTypes(method);
            System.out.println(");");
        }
    }

    /**
     * Prints all fields of a class.
     * @param cl a class
     */
    private static void printFields(Class cl) {
        for (Field field : cl.getDeclaredFields()) {
            System.out.print(INDENT);

            printModifiers(field.getModifiers());
            System.out.println(field.getType().getName() + " " + field.getName() + ";");
        }
    }

    private static void printModifiers(int setOfModifiers) {
        String modifiers = Modifier.toString(setOfModifiers);
        if (modifiers.length() > 0) {
            System.out.print(modifiers + " ");
        }
    }

    private static void printParameterTypes(Executable executable) {
        Class[] paramTypes = executable.getParameterTypes();
        for (int j = 0; j < paramTypes.length; j++) {
            if (j > 0) System.out.print(", ");
            System.out.print(paramTypes[j].getName());
        }
    }
}
