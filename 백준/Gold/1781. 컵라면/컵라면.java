import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Problem implements Comparable<Problem> {
        int deadline;
        int ramen;

        Problem(int deadline, int ramen) {
            this.deadline = deadline;
            this.ramen = ramen;
        }

        @Override
        public int compareTo(Problem o) { // deadLine 기준 오름차순으로 정렬
            return Integer.compare(this.deadline, o.deadline);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Problem[] problems = new Problem[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadLine = Integer.parseInt(st.nextToken());
            int ramen = Integer.parseInt(st.nextToken());
            problems[i] = new Problem(deadLine, ramen);
        }
        Arrays.sort(problems);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Problem problem : problems) {
            pq.offer(problem.ramen);
            if (pq.size() > problem.deadline) { // 마감일 초과 검사
                pq.poll(); // 보상이 가장 작은 문제 제거
            }
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            answer += pq.poll();
        }
        System.out.println(answer);
    }
}