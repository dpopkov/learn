package learn.dsai.ch08trees2.huffman;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {
    private static final int TABLE_SIZE = 28;

    private final ChNode root;
    private String[] codes;

    public HuffmanTree(String message) {
        Map<Character, Integer> frequencies = countChars(message);
        root = buildTree(frequencies);
        buildCodes();
    }

    public String[] getCodes() {
        return codes;
    }

    private void buildCodes() {
        codes = new String[TABLE_SIZE];
        traverse("", root);
    }

    private void traverse(String charCode, ChNode node) {
        if (node == null) {
            return;
        }
        if (node.character != 0) {
            codes[char2index(node.character)] = charCode;
        } else {
            traverse(charCode + "0", node.left);
            traverse(charCode + "1", node.right);
        }
    }

    private int char2index(char character) {
        if (character >= 'A' && character <= 'Z') {
            return character - 'A';
        } else if (character == ' ') {
            return 26;
        } else if (character == '\n') {
            return 27;
        }
        throw new IllegalArgumentException("Not allowed character: '" + character + "'");
    }

    private ChNode buildTree(Map<Character, Integer> frequencies) {
        PriorityQueue<ChNode> queue = new PriorityQueue<>();
        frequencies.forEach((k, v) -> queue.add(new ChNode(k, v)));
        while (queue.size() > 1) {
            ChNode n1 = queue.remove();
            ChNode n2 = queue.remove();
            ChNode n = new ChNode((char) 0, n1.frequency + n2.frequency);
            n.left = n1;
            n.right = n2;
            queue.add(n);
        }
        return queue.remove();
    }

    private static Map<Character, Integer> countChars(String message) {
        Map<Character, Integer> char2frequency = new HashMap<>();
        for (int i = 0; i < message.length(); i++) {
            char2frequency.merge(message.charAt(i), 1, (i1, i2) -> i1 + 1);
        }
        return char2frequency;
    }
}
