import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static Deque<Integer> deque = new ArrayDeque<>();

    public static int findPosition(int goal) {
        int index = 1;
        for (int num : deque) {
            if (num == goal) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        int answer = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int goal = Integer.parseInt(st.nextToken());
            int goal_idx = findPosition(goal);
            int leftToGo = goal_idx - 1;
            int rightToGo = deque.size() - goal_idx + 1;

            if (leftToGo <= rightToGo) {
                for (int j = 0; j < leftToGo; j++) {
                    deque.addLast(deque.removeFirst());
                    answer++;
                }
            } else {
                for (int j = 0; j < rightToGo; j++) {
                    deque.addFirst(deque.removeLast());
                    answer++;
                }
            }
            deque.removeFirst();
        }
        System.out.println(answer);
    }
}