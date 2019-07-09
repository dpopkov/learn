package learn.dsajg6e.ch06stacks.exer;

import learn.dsajg6e.ch06stacks.LinkedQueue;
import learn.dsajg6e.ch06stacks.Queue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P0636StockShare {
    private final Queue<Share> fifo = new LinkedQueue<>();
    private int capitalGain;

    /**
     * Runs a transaction of the form
     * "buy x share(s) at $y each" or "sell x share(s) at $y each".
     * @param action text of the transaction
     */
    public void transaction(String action) {
        Pattern p = Pattern.compile("(buy|sell) (\\d+) share\\(s\\) at \\$(\\d+) each");
        Matcher matcher = p.matcher(action);
        if (matcher.matches()) {
            String cmd = matcher.group(1);
            int quantity = Integer.parseInt(matcher.group(2));
            int price = Integer.parseInt(matcher.group(3));
            if ("buy".equals(cmd)) {
                for (int i = 0; i < quantity; i++) {
                    Share share = new Share(price);
                    fifo.enqueue(share);
                }
            } else {
                for (int i = 0; i < quantity; i++) {
                    Share share = fifo.dequeue();
                    int gain = price - share.getPrice();
                    capitalGain += gain;
                }
            }
        } else {
            throw new IllegalArgumentException("Not valid action: " + action);
        }
    }

    public int capitalGain() {
        return capitalGain;
    }

    private static class Share {
        private final int price;

        public Share(int price) {
            this.price = price;
        }

        public int getPrice() {
            return price;
        }
    }
}
