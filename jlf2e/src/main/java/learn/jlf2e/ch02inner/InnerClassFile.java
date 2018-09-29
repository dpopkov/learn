package learn.jlf2e.ch02inner;

@SuppressWarnings("unused")
public class InnerClassFile {

    public class MemberInnerClass {}

    public static class NestedClass {}

    public void testMethod1() {
        class LocalInnerClass {
            class LocalInnerClass2 {}
        }

        class AnotherLocalInnerClass {}

        new Object() {};
    }

    public void testMethod2() {
        class AnotherLocalInnerClass {}

        class TestLocalClass{}
    }

    public static void main(String[] args) {
        System.out.println("It demonstrates generating file names for inner classes.");
    }
}
