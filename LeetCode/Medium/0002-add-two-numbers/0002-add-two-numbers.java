import java.math.BigInteger;

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

    public BigInteger toBigInt(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val);
            node = node.next;
        }
        return new BigInteger(sb.toString());
    }

    public ListNode toReverseLinkedList(BigInteger val) {
        ListNode prev = null, node = null;
        for (char ch : String.valueOf(val).toCharArray()) {
            // 노드간 연결 맺기
            node = new ListNode(Character.getNumericValue(ch));
            node.next = prev;
            prev = node;
        }
        return node;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 역순으로 뒤집기
        ListNode l1Reversed = reverse(l1, null);
        ListNode l2Reversed = reverse(l2, null);

        BigInteger result = toBigInt(l1Reversed).add(toBigInt(l2Reversed));
        return toReverseLinkedList(result);
    }
}