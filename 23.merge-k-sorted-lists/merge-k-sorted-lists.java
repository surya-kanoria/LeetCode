import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length <= 0) {
            return null;
        }
        ListNode[] temp = new ListNode[lists.length];
        ListNode solution = null;
        ListNode result = null;
        for (int i = 0; i < lists.length; i++) {

            temp[i] = lists[i];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(lists.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                return temp[n1.intValue()].val - temp[n2.intValue()].val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.add(i);
            }
        }

        while (queue.size() > 0) {
            int index = queue.poll();
            System.out.println(temp[index].val);
            if (solution == null) {
                solution = temp[index];
                result = solution;
            } else {
                solution.next = temp[index];
                solution = solution.next;
            }
            if (temp[index].next != null) {
                temp[index] = temp[index].next;
                queue.add(index);
            }
        }
        return result;
    }
}