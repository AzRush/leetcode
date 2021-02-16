/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode ret = head;
        int add = 0;
        while(l1 != null && l2 != null){
            int val = l1.val + l2.val + add;
            if(val >= 10){
                add = 1;
                val -= 10;
            }
            else
                add = 0;
            ListNode l3 = new ListNode(val);
            ret.next = l3;
            ret = l3;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 == null)l1 = l2;
        while(l1 != null){
            int val = l1.val + add;
            if(val >= 10){
                add = 1;
                val -= 10;
            }
            else
                add = 0;
            ListNode l3 = new ListNode(val);
            ret.next = l3;
            ret = l3;
            l1 = l1.next;
        }
        if(add == 1)ret.next = new ListNode(1);
        ret = head.next;
        return ret;

    }
}
