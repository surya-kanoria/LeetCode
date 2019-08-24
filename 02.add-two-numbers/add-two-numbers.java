/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumList;
        ListNode temp;
        ListNode temp2;
        int carry = 0;
       
        return addIndividualCell(l1,l2,null,0);
    }
    
    public ListNode addIndividualCell(ListNode l1, ListNode l2, ListNode sumList, int carryForward){
        int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carryForward;
        int carry = sum / 10;
        sum = sum % 10;
        System.out.println(sum);
        sumList = new ListNode(sum);
        if((l1 == null || l1.next == null) && (l2 == null || l2.next == null) && (carry == 0)) {
            return sumList;            
        } else{
            sumList.next = addIndividualCell((l1 != null ? l1.next : null),(l2 != null ? l2.next : null),null,carry);
        }
        return sumList;
    }
}