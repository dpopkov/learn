package learn.dsai.ch05.lists;

public class Link {
    public int iData;
    public double dData;
    public Link next;

    public Link(int iData, double dData) {
        this.iData = iData;
        this.dData = dData;
    }

    @Override
    public String toString() {
        return "{" + iData + ", " + dData + '}';
    }
}
