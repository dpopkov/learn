package learn.dsai.ch08trees.projects;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {
    public static void main(String[] args) {
        /* Making Huffman tree. */
        String s = "SUSIE SAYS IT IS EASY";
        Map<Character, Integer> frequencies = new HashMap<>();
        s.chars().forEach(ch -> frequencies.merge((char)ch, 1, (i, i2) -> i + 1));
        PriorityQueue<NodeFreqChar> queue = new PriorityQueue<>(Comparator.comparingInt(NodeFreqChar::getFrequency));
        frequencies.forEach((ch, freq) -> queue.add(new NodeFreqChar(ch, freq)));
        NodeFreqChar n1 = queue.remove();
        NodeFreqChar n2 = queue.remove();
        NodeFreqChar n = new NodeFreqChar((char) 0, n1.getFrequency() + n2.getFrequency());
        n.left = n1;
        n.right = n2;
        queue.add(n);
        /*while (queue.size() > 1) {
            // TODO: implement the rest
        }*/
    }
}
