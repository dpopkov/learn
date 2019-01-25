package learn.core1.ch08generics.reflection2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class C080901GenericClass {
    @SuppressWarnings("UnnecessaryLocalVariable")
    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        System.out.println("stringClass.getName() = " + stringClass.getName());
        try {
            String s = stringClass.newInstance();
            System.out.println("s = " + s);
            System.out.println("s.length() = " + s.length());
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        String s2 = "This is string";
        Object obj = s2;
        String s3 = stringClass.cast(obj);
        System.out.println("s3 = " + s3);

        Class<Drink> drinksClass = Drink.class;
        Drink[] drinks = drinksClass.getEnumConstants();
        System.out.println("drinks = " + Arrays.toString(drinks));

        Class<? super Drink> superClass = drinksClass.getSuperclass();
        System.out.println("superClass.getName() = " + superClass.getName());

        Class<Break> breakClass = Break.class;
        try {
            Constructor<Break> constructor = breakClass.getDeclaredConstructor(Drink.class);
            Break coffeeBreak = constructor.newInstance(Drink.COFFEE);
            System.out.println("coffeeBreak = " + coffeeBreak);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    enum Drink {TEE, COFFEE, WATER}

    static class Break {
        private Drink drink;

        Break(Drink drink) {
            this.drink = drink;
        }

        @Override
        public String toString() {
            return "{Drink:" + drink + "}";
        }
    }
}
