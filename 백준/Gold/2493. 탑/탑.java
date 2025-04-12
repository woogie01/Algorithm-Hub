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

        Deque<Tower> stack = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            int newHeight = Integer.parseInt(st.nextToken());

            if (stack.isEmpty()) { // 초기 1회 시행
                result.append("0 ");
                stack.push(new Tower(i, newHeight));
            } else {
                while (true) { 
                    if (stack.isEmpty()) { // 순회 종료 조건(1)
                        result.append("0 ");
                        stack.push(new Tower(i, newHeight));
                        break;
                    }

                    Tower tower = stack.peek();
                    if (tower.height > newHeight) { // 순회 종료 조건(2)
                        result.append(tower.num).append(" ");
                        stack.push(new Tower(i, newHeight));
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
        }
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}