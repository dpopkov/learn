/* Listing 12.6 */
package learn.ijpds.ch12exceptions;

public class TestException {
    public static void main(String[] args) {
        try {
            System.out.println(sum(new int[] {1, 2, 3, 4, 5}));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\nmessage: " + e.getMessage());
            System.out.println("\ntoString(): " + e.toString());
            System.out.println("\nTrace Info Obtained from getStackTrace");
            StackTraceElement[] frames = e.getStackTrace();
            for (StackTraceElement frame : frames) {
                System.out.print("method " + frame.getMethodName());
                System.out.print("(" + frame.getClassName() + ":");
                System.out.println(frame.getLineNumber() + ")");
            }
        }
    }

    private static int sum(int[] list) {
        int result = 0;
        for (int i = 0; i <= list.length; i++) {
            result += list[i];
        }
        return result;
    }
}
