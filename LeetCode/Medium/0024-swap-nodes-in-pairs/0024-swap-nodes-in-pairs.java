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
    public ListNode swapPairs(ListNode head) {
       if (head != null && head.next != null) {
           // head, tail
           ListNode tail = head.next;
           ListNode nextHead = tail.next;
           
           // 뒤의 스왑으로 바뀔 노드를 연결
           head.next = swapPairs(nextHead);

           // head, tail 역순으로 연결
           tail.next = head;
           return tail;
       }
       return head;
    }
}
