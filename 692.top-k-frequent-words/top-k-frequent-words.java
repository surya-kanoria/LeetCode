import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            int count = countMap.getOrDefault(word, 0);
            countMap.put(word, count + 1);
        }
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(new Comparator<String>() {
            public int compare(String s1, String s2) {
                int diff = countMap.get(s1) - countMap.get(s2);
                return (diff != 0 ? diff : s2.compareToIgnoreCase(s1));
            }
        });
        for (String word : countMap.keySet()) {
            priorityQueue.offer(word);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        Stack<String> reverseAns = new Stack<>();
        while (!priorityQueue.isEmpty()) {
            reverseAns.add(priorityQueue.poll());
        }
        List<String> ans = new ArrayList<>();
        while (!reverseAns.isEmpty()) {
            ans.add(reverseAns.pop());
        }
        return ans;
    }
}