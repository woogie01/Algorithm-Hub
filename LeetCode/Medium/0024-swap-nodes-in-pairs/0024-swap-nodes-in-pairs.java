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
        // 임시 노드 
        ListNode node = new ListNode(0);
        ListNode root = node;

        node.next = head;
        while (node.next != null && node.next.next != null) {
            
            // node(=front), mid, end
            ListNode mid = node.next;
            ListNode end = node.next.next;

            // Swap
            mid.next = end.next;
            node.next= end;
            node.next.next = mid;

            // 두 칸 이동
            node = node.next.next;
        }
        // 임시 노드는 제외
        return root.next;
    }
}
