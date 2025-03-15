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
     public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        // 홀수 노드 : oddHead = odd(head)
        ListNode odd = head;
        // 짝수 노드
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            // 각 홀짝 노드 연결
            odd.next = odd.next.next;
            even.next = even.next.next;
            // 각각 다음 노드로
            odd = odd.next;
            even = even.next;
        }
        // 홀수 노드, 짝수 노드 연결
        odd.next = evenHead;
        return head;
    }
}
