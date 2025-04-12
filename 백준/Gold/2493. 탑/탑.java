import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static class Tower {
        int num;
        int height;

        Tower(int num, int height) {
            this.num = num;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Tower> stack = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            int newHeight = Integer.parseInt(st.nextToken());

            // 뒤로 순회하면서 검사
            while (!stack.isEmpty() && stack.peek().height <= newHeight) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result.append("0 ");
            } else {
                result.append(stack.peek().num).append(" ");
            }
            stack.push(new Tower(i, newHeight));
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
