import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public boolean isPossible(int[] nums) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new Comparator<List<Integer>>() {
            public int compare(List<Integer> l1, List<Integer> l2) {
                if (l1.get(l1.size() - 1) != l2.get(l2.size() - 1)) {
                    System.out.println("Compare : " + l1.get(l1.size() - 1) + " , " + l2.get(l2.size() - 1));
                    return -1 * (l1.get(l1.size() - 1) - l2.get(l2.size() - 1));
                } else {
                    return (l1.size() - l2.size());
                }
            }
        });
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (pq.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                pq.offer(list);
                count = count + 1;
                System.out.println(nums[i]);
                continue;
            }
            List<Integer> list = pq.poll();
            if (nums[i] - list.get(list.size() - 1) == 1) {
                list.add(nums[i]);
                System.out.println(nums[i] + " , " + list.get(list.size() - 1) + "  " + list.size());
                if (list.size() == 3) {
                    count = count - 1;
                }
                pq.offer(list);
            } else {
                pq.add(list);
                List<Integer> newList = new ArrayList<>();
                newList.add(nums[i]);
                pq.offer(newList);
                count = count + 1;
                System.out.println(nums[i]);
            }
        }
        System.out.println("Final count : " + count);
        return count == 0;
    }
}