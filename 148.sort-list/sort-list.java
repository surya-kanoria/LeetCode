/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        return sort(head);
    }

    public ListNode sort(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        if (size <= 1) {
            return head;
        }
        ListNode left = head, right = head, rightPrev = head;
        for (int i = 0; i < size / 2; i++) {
            rightPrev = right;
            right = right.next;
        }
        rightPrev.next = null;
        left = sort(left);
        right = sort(right);
        ListNode solution;
        ListNode result;
        if (left.val < right.val) {
            solution = left;
            result = left;
            left = left.next;
        } else {
            solution = right;
            result = right;
            right = right.next;
        }
        while (left != null && right != null) {
            if (left.val < right.val) {
                result.next = left;
                left = left.next;
                result = result.next;
            } else {
                result.next = right;
                right = right.next;
                result = result.next;
            }
        }
        if (left != null) {
            result.next = left;
        }
        if (right != null) {
            result.next = right;
        }
        return solution;
    }
}