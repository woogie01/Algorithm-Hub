import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static Deque<Integer> deque;
    static StringBuilder sb = new StringBuilder();

    public static void AC(String function) {

        boolean isFront = true;

        for (char cmd : function.toCharArray()) {

            // 뒤집기 커맨드 R
            if (cmd == 'R') {
                isFront = !isFront;
                continue;
            }

            // 삭제 커맨드 D
            if (isFront) {
                if (deque.pollFirst() == null) {
                    sb.append("error\n");
                    return;
                }
            } else {
                if (deque.pollLast() == null) {
                    sb.append("error\n");
                    return;
                }
            }
        }

        // 결과 저장
        sb.append('[');
        if (!deque.isEmpty()) {
            if (isFront) {
                sb.append(deque.pollFirst());
                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            } else {
                sb.append(deque.pollLast());
                while(!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            }
        }
        sb.append(']').append('\n');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String function = br.readLine();
            int N = Integer.parseInt(br.readLine());
            deque = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            for (int j = 0; j < N; j++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }
            AC(function);
        }
        System.out.println(sb);
    }
}