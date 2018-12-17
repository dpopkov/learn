package learn.dsai.ch11ht.projects;

import learn.dsai.tools.MathTools;

public class P1103Folding {
    public static int fold(int value, int groupSize) {
        int sum = 0;
        int divider = MathTools.pow(10, groupSize);
        int rst;
        while (value > 0) {
            rst = value % divider;
            sum += rst;
            value /= divider;
        }
        return sum % divider;
    }
}
