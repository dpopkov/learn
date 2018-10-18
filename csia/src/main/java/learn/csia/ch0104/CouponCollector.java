/* 1.4.2
Coupon collector simulation.
Takes an integer argument n and simulates coupon collection
by generating random number between 0 and n - 1 until getting
every possible value.
*/
package learn.csia.ch0104;

import learn.csia.utils.CliAppArgs;

public class CouponCollector {
    public static void main(String[] args) {
        CliAppArgs cli = new CliAppArgs(args, "Number of coupon values");
        int numCouponValues = cli.nextInt();
        boolean[] isCollected = new boolean[numCouponValues];
        int count = 0;
        int distinct = 0;
        while (distinct < numCouponValues) {
            int r = (int) (Math.random() * numCouponValues);
            count++;
            if (!isCollected[r]) {
                distinct++;
                isCollected[r] = true;
            }
        }
        System.out.println(count);
    }
}
