package learn.dsajg6e.ch02oop.generics;

@SuppressWarnings("unused")
public class GenericMethodDemo {
    public static <T> void reverse(T[] data) {
        for (int low = 0, high = data.length - 1; low < high; low++, high--) {
            T temp = data[low];
            data[low] = data[high];
            data[high] = temp;
        }
    }
}
