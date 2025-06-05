import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> maxPQ = new PriorityQueue<>((o1,o2) -> o2-o1);  // 내림차순
        Queue<Integer> minPQ = new PriorityQueue<>((o1, o2) -> o1-o2); // 오름차순
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (maxPQ.size() == minPQ.size()) maxPQ.add(num);
            else minPQ.add(num);

            if (!minPQ.isEmpty() && !maxPQ.isEmpty()) {
                if (maxPQ.peek() > minPQ.peek()) {
                    int tmp = maxPQ.poll();
                    maxPQ.add(minPQ.poll());
                    minPQ.add(tmp);
                }
            }
            sb.append(maxPQ.peek()).append("\n");
        }
        System.out.println(sb);
    }
}