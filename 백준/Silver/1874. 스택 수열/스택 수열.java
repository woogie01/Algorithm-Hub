import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();

        int cur = 0;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (cur < tmp) {
                for (int j = cur + 1; j <= tmp; j++) {
                    stack.push(j);
                    result.append("+").append("\n");
                }
                cur = tmp;
            } else if (stack.peek() != tmp) {
                System.out.println("NO");
                return;
            }

            // stack.pop : 수열에 넣기
            stack.pop();
            result.append("-").append("\n");
        }

        // 출력
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
