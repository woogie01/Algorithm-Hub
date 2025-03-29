import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 받기
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ListNode head = new ListNode(1);
        ListNode curr = head;
        for (int i = 2; i <= N; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        curr.next = head;

        StringBuilder sb = new StringBuilder("<");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K - 1; j++) {
                curr = curr.next;
            }

            // 정답 저장
            ListNode toRemove = curr.next;
            sb.append(toRemove.val);
            if (i < N - 1) {
                sb.append(", ");
            }

            // 노드 연결
            curr.next = toRemove.next;
        }

        // 정답 출력
        sb.append(">");
        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}