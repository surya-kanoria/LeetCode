import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> groups = new HashMap<>();
        for (String string : strings) {
            if (string.length() == 0) {
                List<String> group = groups.getOrDefault("", new ArrayList<>());
                group.add(string);
                groups.put("", group);
            } else if (string.length() == 1) {
                List<String> group = groups.getOrDefault("-1", new ArrayList<>());
                group.add(string);
                groups.put("-1", group);
            } else {
                StringBuilder key = new StringBuilder();
                for (int i = 1; i < string.length(); i++) {
                    int diff = string.charAt(i) - string.charAt(i - 1);
                    diff = diff < 0 ? diff + 26 : diff;
                    key.append((char) diff);
                }
                List<String> group = groups.getOrDefault(key.toString(), new ArrayList<>());
                group.add(string);
                groups.put(key.toString(), group);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : groups.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}