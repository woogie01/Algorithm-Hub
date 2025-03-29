import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static class ListNode {
        int val;
        ListNode prev;  
        ListNode next;  

        ListNode() { }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode prev, ListNode next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int M = Integer.parseInt(br.readLine());

        // 이중연결리스트에 사용할 더미 노드 생성
        ListNode head = new ListNode(0);
        ListNode tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;

        // 초기 문자열의 각 문자를 tail 앞에 삽입
        for (char ch : input.toCharArray()) {
            ListNode newNode = new ListNode(ch);
            // tail 앞에 newNode 삽입
            newNode.prev = tail.prev;
            newNode.next = tail;
            tail.prev.next = newNode;
            tail.prev = newNode;
        }

        // 커서는 처음에 tail(즉, 리스트의 끝)을 가리킴.
        ListNode cursor = tail;

        // M번의 명령 처리
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            switch(op) {
                case "L": // 커서를 왼쪽으로 이동
                    if (cursor.prev != head) {
                        cursor = cursor.prev;
                    }
                    break;
                case "D": // 커서를 오른쪽으로 이동
                    if (cursor != tail) {
                        cursor = cursor.next;
                    }
                    break;
                case "B": // 커서 왼쪽 문자 삭제
                    if (cursor.prev != head) {
                        ListNode toRemove = cursor.prev;
                        toRemove.prev.next = cursor;
                        cursor.prev = toRemove.prev;
                    }
                    break;
                case "P": // 커서 왼쪽에 문자 삽입
                    char c = st.nextToken().charAt(0);
                    ListNode newNode = new ListNode(c);
                    newNode.prev = cursor.prev;
                    newNode.next = cursor;
                    cursor.prev.next = newNode;
                    cursor.prev = newNode;
                    break;
            }
        }

        // 정답 출력
        StringBuilder sb = new StringBuilder();
        for (ListNode cur = head.next; cur != tail; cur = cur.next) {
            sb.append((char) cur.val);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
