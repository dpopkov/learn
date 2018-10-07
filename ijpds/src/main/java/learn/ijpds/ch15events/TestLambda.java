package learn.ijpds.ch15events;

public class TestLambda {
    public static void main(String[] args) {
        TestLambda test = new TestLambda();
        test.setAction1(() -> System.out.print("Action 1! "));
        test.setAction2(d -> System.out.print(d + " "));
        System.out.println(test.getValue((e1, e2) -> e1 + e2));
    }

    void setAction1(T1 t) {
        t.m1();
    }

    void setAction2(T2 t) {
        t.m2(4.5);
    }

    int getValue(T3 t) {
        return t.m3(5, 2);
    }

    @FunctionalInterface
    private interface T1 {
        void m1();
    }

    @FunctionalInterface
    private interface T2 {
        void m2(Double d);
    }

    @FunctionalInterface
    private interface T3 {
        int m3(int d1, int d2);
    }

}
