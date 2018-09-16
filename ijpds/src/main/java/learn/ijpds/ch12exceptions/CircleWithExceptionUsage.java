package learn.ijpds.ch12exceptions;

public class CircleWithExceptionUsage {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        try {
            CircleWithException c1 = new CircleWithException(5);
            CircleWithException c2 = new CircleWithException(-5);
            CircleWithException c3 = new CircleWithException(0);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
        }

        System.out.println("Number of objects created: " + CircleWithException.getNumberOfObjects());
    }
}
