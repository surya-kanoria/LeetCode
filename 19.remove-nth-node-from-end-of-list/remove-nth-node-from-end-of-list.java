/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front = head, back = head;
        for (int i = 0; i < n; i++) {
            front = front.next;
        }
        if (front != null) {
            while (front.next != null) {
                back = back.next;
                front = front.next;
            }
            ListNode temp = back.next;
            back.next = temp.next;
        } else {
            head = head.next;
        }
        return head;
    }
}