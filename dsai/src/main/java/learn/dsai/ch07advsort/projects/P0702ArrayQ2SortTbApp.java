package learn.dsai.ch07advsort.projects;

public class P0702ArrayQ2SortTbApp {
    public static void main(String[] args) {
        int[] sizes = {8, 16, 32};
        for (int maxSize : sizes) {
            System.out.println("maxSize = " + maxSize);
            P0702ArrayQ2SortTb arr;
            arr = new P0702ArrayQ2SortTb(maxSize);
            while (arr.isNotFull()) {
                arr.insert((long) (Math.random() * 100));
            }
            arr.display();
            arr.sort();
            arr.display();
            arr.displayStats();
        }
    }
}
