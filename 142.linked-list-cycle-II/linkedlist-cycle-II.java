/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        do {
            if (slow != null) {
                slow = slow.next;
            } else {
                return null;
            }
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
        } while (slow != null && fast != null && slow != fast);
        if (slow != null && fast != null) {
            ListNode temp1 = slow;
            ListNode temp2 = head;
            while (temp1 != temp2) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            return temp1;
        } else {
            return null;
        }
    }
}