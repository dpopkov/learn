package learn.jionio.ch03random;

public class Part {
    public static final int NUMBER_LEN = 20;
    public static final int DESC_LEN = 30;
    public static final int QTY_LEN = 4;
    public static final int COST_LEN = 4;
    public static final int RECORD_LEN = 2 * NUMBER_LEN + 2 * DESC_LEN + QTY_LEN + COST_LEN;

    private String number;
    private String description;
    private int qty;
    private int cost;

    public Part(String number, String description, int qty, int cost) {
        this.number = number;
        this.description = description;
        this.qty = qty;
        this.cost = cost;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
