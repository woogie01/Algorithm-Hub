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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 예외 처리
        if (head == null) {
            return null;
        }

        // 임시 노드
        ListNode root = new ListNode(0);
        root.next = head;

        // 위치는 1부터 시작 : start = left 위치 앞의 노드
        ListNode start = root;
        for (int i = 0; i < left - 1; i++) {
            start = start.next;
        }
        // end : left 위치부터 right 위치까지 뒤집으려는 구간의 첫 번째 노드
        ListNode end = start.next;

        // 뒤로 밀려나면서 위치 변경 진행
        for (int i = 0; i < right - left; i++) {
            ListNode tmp = start.next;   // 기존 start.next를 저장 (중간 연결을 위해)
            start.next = end.next;       // start.next를 end.next로 변경 (가장자리 연결)
            end.next = end.next.next;    // end.next를 한 칸 뒤로 이동 (리스트 유지)
            start.next.next = tmp;       // 새로 연결한 노드의 다음을 tmp로 설정 (중간 연결)
        }
        // 임시 노드 제외
        return root.next;
    }
}