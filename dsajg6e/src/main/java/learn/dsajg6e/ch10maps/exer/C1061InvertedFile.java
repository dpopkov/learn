package learn.dsajg6e.ch10maps.exer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
C-10.61
 */
public class C1061InvertedFile {
    private final Map<String, List<Integer>> map = new HashMap<>();

    public C1061InvertedFile(List<String> document) {
        for (int i = 0; i < document.size(); i++) {
            map.computeIfAbsent(document.get(i), k -> new ArrayList<>()).add(i);
        }
    }

    public List<Integer> indicesForWord(String word) {
        return map.get(word);
    }
}
