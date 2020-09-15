import java.util.HashSet;

class Solution {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            if (map.containsKey(names[i])) {
                int j = map.get(names[i]);
                while (map.containsKey(names[i] + "(" + j + ")"))
                    j++;
                map.put(names[i], j + 1);
                names[i] += "(" + j + ")";
            }
            map.put(names[i], 1);
        }
        return names;
    }
}