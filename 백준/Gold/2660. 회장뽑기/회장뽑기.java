import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<Integer>[] graph;
    static final int MAX_VALUE = 50;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1) break;
            graph[a].add(b);
            graph[b].add(a);
        }

        int[] score = new int[N + 1];
        int best = MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            score[i] = bfs(i);
            best = Math.min(best, score[i]);
        }

        StringBuilder sb = new StringBuilder();
        List<Integer> candidates = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (score[i] == best) candidates.add(i);
        }

        sb.append(best).append(' ').append(candidates.size()).append('\n');
        for (int i = 0; i < candidates.size(); i++) {
            if (i > 0) sb.append(' ');
            sb.append(candidates.get(i));
        }
        System.out.println(sb);
    }

    static int bfs(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);
        Deque<Integer> queue = new ArrayDeque<>();
        
        dist[start] = 0;
        queue.addLast(start);
        while (!queue.isEmpty()) {
            int cur = queue.pollFirst();
            for (int nxt : graph[cur]) {
                if (dist[nxt] == -1) {
                    dist[nxt] = dist[cur] + 1;
                    queue.addLast(nxt);
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == -1) return MAX_VALUE;
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}