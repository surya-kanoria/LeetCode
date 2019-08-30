/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head != null ? head.next : head;
        ListNode fastest = head != null && head.next != null ? head.next.next : null;
        while (slow != null) {
            while (slow != null && fast != null && slow != fast) {
                slow = slow.next;
                if (fast.next != null) {
                    fast = fast.next.next;
                } else {
                    return null;
                }
            }
        }
        System.out.println(slow.val);
        return slow;
    }
}