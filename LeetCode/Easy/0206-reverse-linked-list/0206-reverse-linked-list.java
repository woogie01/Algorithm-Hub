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
    public ListNode reverse(ListNode node, ListNode prev) {
        // 종료 조건
        if (node == null) {
            return prev;
        }

        // 다음 노드와 현재 노드로 재귀함수 호출
        ListNode next = node.next;
        node.next = prev;
        return reverse(next, node);
    }

    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }
}