import java.util.HashMap;

class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        HashMap<Integer, String> sourceMap = new HashMap<>();
        HashMap<Integer, String> targetMap = new HashMap<>();
        for (int i = 0; i < indexes.length; i++) {
            sourceMap.put(indexes[i], sources[i]);
            targetMap.put(indexes[i], targets[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (sourceMap.containsKey(i)) {
                String subString = S.substring(i, i + sourceMap.get(i).length());
                if (subString.compareTo(sourceMap.get(i)) == 0) {
                    sb.append(targetMap.get(i));
                    i = i + (subString.length() - 1);
                    continue;
                }
            }
            sb.append(S.charAt(i));
        }
        return sb.toString();
    }
}