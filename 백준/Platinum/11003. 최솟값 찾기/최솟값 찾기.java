import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int index;
        int value;

        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수열의 길이
        int L = Integer.parseInt(st.nextToken()); // 윈도우 크기

        st = new StringTokenizer(br.readLine());
        Deque<Node> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            while (!deque.isEmpty() && deque.peekLast().value > cur) {
                deque.pollLast();
            }

            // 값 추가
            deque.addLast(new Node(i, cur));

            // 범위 검사
            if (deque.peekFirst().index <= i - L) {
                deque.removeFirst();
            }

            // 결과 저장
            sb.append(deque.getFirst().value).append(" ");
        }
        System.out.println(sb);
    }
}