package learn.dsai.ch02arrays.array4;

import learn.dsai.tools.ArrayTools;

@SuppressWarnings("ManualArrayCopy")
public class PersonArray {
    private Person[] a;
    private int nElems;

    public PersonArray(int max) {
        a = new Person[max];
        nElems = 0;
    }

    public void insert(String last, String first, int age) {
        Person p = new Person(last, first, age);
        a[nElems++] = p;
    }

    public Person find(String lastName) {
        Person rst = null;
        for (int i = 0; i < nElems; i++) {
            if (a[i].getLastName().equals(lastName)) {
                rst = a[i];
                break;
            }
        }
        return rst;
    }

    public boolean delete(String lastName) {
        int i;
        for (i = 0; i < nElems; i++) {
            if (a[i].getLastName().equals(lastName)) {
                break;
            }
        }
        if (i == nElems) {
            return false;
        } else {
            for (int j = i + 1; j < nElems; j++) {
                a[j - 1] = a[j];
            }
            nElems--;
            return true;
        }
    }

    public void display() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return ArrayTools.toString(a, nElems, System.lineSeparator());
    }
}
