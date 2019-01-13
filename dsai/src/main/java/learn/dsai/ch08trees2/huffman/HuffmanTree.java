package learn.dsai.ch08trees2.huffman;

import java.util.*;

public class HuffmanTree {
    private final ChNode root;
    private String[] huffmanCodes;
    private Map<Character, Integer> char2code;
    private int bitIndex;

    public HuffmanTree(String message) {
        Map<Character, Integer> frequencies = countChars(message);
        buildCharCodes(frequencies.keySet());
        root = buildTree(frequencies);
        buildHuffmanCodes(frequencies.size());
    }

    public String encode(String message) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            builder.append(huffmanCodes[char2index(message.charAt(i))]);
        }
        return builder.toString();
    }

    public String decode(String encoded) {
        StringBuilder builder = new StringBuilder();
        bitIndex = 0;
        while (bitIndex < encoded.length()) {
            builder.append(traverseForChar(encoded));
        }
        return builder.toString();
    }

    private void buildCharCodes(Set<Character> charSet) {
        char2code = new HashMap<>();
        List<Character> charList = new ArrayList<>(charSet);
        Collections.sort(charList);
        for (int i = 0; i < charList.size(); i++) {
            Character ch = charList.get(i);
            char2code.put(ch, i);
        }
    }

    private void buildHuffmanCodes(int tableSize) {
        huffmanCodes = new String[tableSize];
        traverse("", root);
    }

    private void traverse(String charCode, ChNode node) {
        if (node == null) {
            return;
        }
        if (node.character != 0) {
            huffmanCodes[char2index(node.character)] = charCode;
        } else {
            traverse(charCode + "0", node.left);
            traverse(charCode + "1", node.right);
        }
    }

    private char traverseForChar(String bits) {
        ChNode current = root;
        while (current != null && current.character == 0) {
            if (bits.charAt(bitIndex++) == '0') {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if (current == null) {
            throw new IllegalStateException("Could not find character");
        }
        return current.character;
    }

    private int char2index(char character) {
        return char2code.get(character);
    }

    private ChNode buildTree(Map<Character, Integer> frequencies) {
        PriorityQueue<ChNode> queue = new PriorityQueue<>();
        frequencies.forEach((ch, frequency) -> queue.add(new ChNode(ch, frequency)));
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
