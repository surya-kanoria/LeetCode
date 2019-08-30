/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head == null) {
            return head;
        }
        ListNode temp = head;
        int count = 1;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }
        temp.next = head;
        for (int i = 0; i < (count - k); i++) {
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }
}