import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || t.length() <= 0) {
            return "";
        }
        int count = 0, maxCount = Integer.MAX_VALUE, start = 0, end = 0, minStart = -1, minEnd = -1;
        HashMap<Character, Integer> map = new HashMap<>(t.length());
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                int currentVal = map.get(s.charAt(end));
                map.put(s.charAt(end), currentVal - 1);
                if (currentVal == 1) {
                    count = count + 1;
                }
                if (count == map.size()) {
                    if (end - start + 1 < maxCount) {
                        minStart = start;
                        minEnd = end;
                        maxCount = end - start + 1;
                    }
                    while (start <= end) {
                        if (map.containsKey(s.charAt(start))) {
                            int currentValue = map.get(s.charAt(start));
                            map.put(s.charAt(start), currentValue + 1);
                            if (currentValue == 0) {
                                if (end - start + 1 < maxCount) {
                                    minStart = start;
                                    minEnd = end;
                                    maxCount = end - start + 1;
                                }
                                count = count - 1;
                                start++;
                                break;
                            }
                        }
                        start++;
                    }
                }
            }
        }
        if (minStart == -1 || minEnd == -1) {
            return "";
        } else {
            return s.substring(minStart, minEnd + 1);
        }
    }
}