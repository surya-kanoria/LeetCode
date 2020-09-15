import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class Solution {
    public String reorganizeString(String S) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            charCount.put(S.charAt(i), charCount.getOrDefault(S.charAt(i), 0) + 1);
        }
        Character[] characters = charCount.keySet().toArray(new Character[0]);
        Arrays.sort(characters, new Comparator<Character>() {
            public int compare(Character c1, Character c2) {
                return charCount.get(c2) - charCount.get(c1);
            }
        });
        char[] sol = new char[S.length()];
        ArrayList<Integer> availableIndices = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            availableIndices.add(i);
        }
        for (int i = 0; i < characters.length; i++) {
            int currentCount = charCount.get(characters[i]);
            if (currentCount > ((S.length() + 1) / 2)) {
                return "";
            }
            int pos = 0;
            for (int j = 0; j < currentCount; j++) {
                pos = pos % availableIndices.size();
                sol[availableIndices.get(pos)] = characters[i];
                availableIndices.remove(pos);
                pos = pos + 1;
            }
        }
        return String.valueOf(sol);
    }
}