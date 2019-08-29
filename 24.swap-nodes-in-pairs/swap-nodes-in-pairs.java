/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode temp = head;
        int count = 0;
        if (head == null) {
            return head;
        }
        do {
            if (count % 2 == 1) {
                if (temp.next != null && temp.next.next != null) {
                    ListNode next = temp.next;
                    ListNode temp2 = next.next;
                    next.next = next.next.next;
                    temp2.next = next;
                    temp.next = temp2;
                }
            }
            count++;
            temp = temp.next;
        } while (temp != null);
        if (head != null) {
            ListNode headNext = head.next;
            if (headNext != null) {
                head.next = headNext.next;
                headNext.next = head;
                return headNext;
            }
        }
        return head;
    }
}