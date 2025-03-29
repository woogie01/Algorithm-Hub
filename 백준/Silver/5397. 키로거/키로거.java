import java.io.*;

public class Main {

    public static class DoubleListNode {
        int val;
        DoubleListNode prev;  
        DoubleListNode next;  

        DoubleListNode() { }
        DoubleListNode(int val) {
            this.val = val;
        }
        DoubleListNode(int val, DoubleListNode prev, DoubleListNode next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < N; i++) {
            // 입력 받기
            String input = br.readLine();

            // 이중연결리스트에 사용할 더미 노드 head와 tail 생성
            DoubleListNode head = new DoubleListNode(0);
            DoubleListNode tail = new DoubleListNode(0);
            head.next = tail;
            tail.prev = head;

            DoubleListNode cursor = tail;
            for (char ch : input.toCharArray()) {
                switch (ch) {
                    case '<':
                        if (cursor.prev != head) {
                            cursor = cursor.prev;
                        }
                        break;
                    case '>':
                        if (cursor != tail) {
                            cursor = cursor.next;
                        }
                        break;
                    case '-':
                        if (cursor.prev != head) {
                            DoubleListNode toRemove = cursor.prev;
                            toRemove.prev.next = cursor;
                            cursor.prev = toRemove.prev;
                        }
                        break;
                    default:
                        DoubleListNode newNode = new DoubleListNode(ch);
                        newNode.prev = cursor.prev;
                        newNode.next = cursor;
                        cursor.prev.next = newNode;
                        cursor.prev = newNode;
                        break;
                }
            }

            // 정답 저장
            for (DoubleListNode cur = head.next; cur != tail; cur = cur.next) {
                result.append((char) cur.val);
            }
            result.append("\n");
        }
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}