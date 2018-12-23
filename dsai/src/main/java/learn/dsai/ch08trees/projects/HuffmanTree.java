package learn.dsai.ch08trees.projects;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {
    private static final int NUM_CHARACTERS = 28;

    /**
     * Table for characters A..Z, space, linefeed, where A is 0, B is 1,
     * space is 26, and linefeed is 27.
     */
    private final String[] codes = new String[NUM_CHARACTERS];
    private final Map<String, Character> codesToChars = new HashMap<>();

    public HuffmanTree(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Input string is null or empty");
        }
        NodeFreqChar root = buildTree(s);
        fillCodes(root, "");
    }

    public String encode(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            builder.append(codes[getCodeIndex(ch)]);
        }
        return builder.toString();
    }

    public String decode(String s) {
        StringBuilder builder = new StringBuilder();
        int from = 0;
        int to = 2;
        while (to <= s.length()) {
            String code = s.substring(from, to);
            Character ch = codesToChars.get(code);
            if (ch != null) {
                builder.append(ch);
                from = to;
                to = from + 2;
            } else {
                to++;
            }
        }
        return builder.toString();
    }

    private void fillCodes(NodeChar node, String code) {
        if (node.left != null && node.right != null) {
            fillCodes(node.left, code + "0");
            fillCodes(node.right, code + "1");
        } else {
            codes[getCodeIndex(node.character)] = code;
            codesToChars.put(code, node.character);
        }
    }

    private int getCodeIndex(char ch) {
        int codeIdx;
        if ('A' <= ch && ch <= 'Z') {
            codeIdx = ch - 'A';
        } else if (ch == ' ') {
            codeIdx = 26;
        } else if (ch == '\n') {
            codeIdx = 27;
        } else {
            throw new IllegalArgumentException("Character is not valid: " + ch);
        }
        return codeIdx;
    }

    private NodeFreqChar buildTree(String s) {
        Map<Character, Integer> frequencies = new HashMap<>();
        s.chars().forEach(ch -> frequencies.merge((char)ch, 1, (i, i2) -> i + 1));
        PriorityQueue<NodeFreqChar> queue = new PriorityQueue<>(Comparator.comparingInt(NodeFreqChar::getFrequency));
        frequencies.forEach((ch, freq) -> queue.add(new NodeFreqChar(ch, freq)));
        while (queue.size() > 1) {
            NodeFreqChar leftNode = queue.remove();
            NodeFreqChar rightNode = queue.remove();
            int sumFrequency = leftNode.getFrequency() + rightNode.getFrequency();
            NodeFreqChar node = new NodeFreqChar((char) 0, sumFrequency);
            node.left = leftNode;
            node.right = rightNode;
            queue.add(node);
        }
        return queue.remove();
    }

    public static void main(String[] args) {
        String s = "SUSIE SAYS IT IS EASY\n";
        HuffmanTree tree = new HuffmanTree(s);
        String encoded = tree.encode(s);
        System.out.println(encoded);
    }
}
