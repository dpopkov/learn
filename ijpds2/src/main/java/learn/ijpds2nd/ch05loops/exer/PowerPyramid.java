package learn.ijpds2nd.ch05loops.exer;

class PowerPyramid {
    private final int baseNumber;
    private final String space;
    private final String format;

    public PowerPyramid(int blockWidth, int baseNumber) {
        this.baseNumber = baseNumber;
        space = " ".repeat(blockWidth);
        format = String.format("%%%dd", blockWidth);
    }

    public String build(int height) {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < height; r++) {
            sb.append(String.valueOf(space).repeat(height - r - 1));
            for (int c = 0; c <= r; c++) {
                sb.append(String.format(format, (int) Math.pow(baseNumber, c)));
            }
            for (int c = r; c > 0; c--) {
                sb.append(String.format(format, (int) Math.pow(baseNumber, c - 1)));
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
