package learn.dsai.ch02arrays.array1;

public class LowArrayApp {
    public static void main(String[] args) {
        LowArray arr = new LowArray(10);
        int nElems;
        int j;

        arr.setElem(0, 77);
        arr.setElem(1, 99);
        arr.setElem(2, 44);
        arr.setElem(3, 55);
        arr.setElem(4, 22);
        arr.setElem(5, 88);
        arr.setElem(6, 11);
        arr.setElem(7, 0);
        arr.setElem(8, 66);
        arr.setElem(9, 33);
        nElems = 10;

        System.out.println(arr.toString(nElems));

        int searchKey = 26;
        for (j = 0; j < nElems; j++) {
            if (arr.getElem(j) == searchKey) {
                break;
            }
        }
        if (j == nElems) {
            System.out.println("Can't find " + searchKey);
        } else {
            System.out.println("Found " + searchKey);
        }

        searchKey = 55;
        for (j = 0; j < nElems; j++) {
            if (arr.getElem(j) == searchKey) {
                break;
            }
        }
        for(int k = j; k < nElems - 1; k++) {
            arr.setElem(k, arr.getElem(k + 1));
        }
        nElems--;
        System.out.println(arr.toString(nElems));
    }
}
