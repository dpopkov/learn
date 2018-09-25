package learn.ijpds.ch19generics;

public class GenericSort {
    public static void main(String[] args) {
        Integer[] intArray = {2, 4, 3};
        Double[] doubleArray = {3.4, 1.3, -22.1};
        Character[] charArray = {'a', 'J', 'r'};
        String[] stringArray = {"Tom", "Susan", "Kim"};
        sort(intArray);
        sort(doubleArray);
        sort(charArray);
        sort(stringArray);
        printList("Sorted Integer objects: ", intArray);
        printList("Sorted Double objects: ", doubleArray);
        printList("Sorted Character objects: ", charArray);
        printList("Sorted String objects: ", stringArray);
    }

    private static <E extends Comparable<E>> void sort(E[] list) {
        E currentMin;
        int currentMinIndex;
        for (int i = 0; i < list.length - 1; i++) {
            currentMin = list[i];
            currentMinIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (currentMin.compareTo(list[j]) > 0) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }

    private static void printList(String caption, Object[] list) {
        System.out.print(caption);
        for (Object obj : list) {
            System.out.print(obj);
            System.out.print(" ");
        }
        System.out.println();
    }
}
