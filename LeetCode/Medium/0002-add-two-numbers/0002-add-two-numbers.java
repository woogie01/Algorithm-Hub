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
        // 초기 계산을 위한 임시 노드
        ListNode node = new ListNode(0);
        ListNode root = node;

        int sum, carry = 0, remainder;
        while (l1 != null || l2 != null || carry != 0) {
            sum = 0;
            // 첫 번째 연결 리스트 계산
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            // 두 번째 연결 리스트 계산
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // 노드에 남길 값 
            remainder = (sum + carry) % 10;
            carry = (sum + carry) / 10;

            // 뒤집어서 노드 연결
            node.next = new ListNode(remainder);
            node = node.next;
        }
        // 첫 번째 노드는 제외하고 반환
        return root.next;
    }
}