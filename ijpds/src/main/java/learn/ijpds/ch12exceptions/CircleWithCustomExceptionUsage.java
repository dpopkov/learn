package learn.ijpds.ch12exceptions;

@SuppressWarnings("unused")
public class CircleWithCustomExceptionUsage {
    public static void main(String[] args) {
        try {
            CircleWithCustomException c1 = new CircleWithCustomException(5);
            CircleWithCustomException c2 = new CircleWithCustomException(-5);
            CircleWithCustomException c3 = new CircleWithCustomException(0);
        } catch (InvalidRadiusException ex) {
            System.out.println(ex.toString());
        }

        System.out.println("Number of objects created: " + CircleWithCustomException.getNumberOfObjects());
    }
}
