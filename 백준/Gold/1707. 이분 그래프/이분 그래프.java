import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V + 1];
            for (int j = 1; j <= V; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int k = 0; k < E; k++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }

            boolean result = bfs(V);
            answer.append(result ? "YES\n" : "NO\n");
        }
        System.out.print(answer);
    }

    private static boolean bfs(int V) {
        int[] colors = new int[V + 1];
        Deque<Integer> queue = new ArrayDeque<>();

        for (int s = 1; s <= V; s++) {
            if (colors[s] != 0) continue;

            colors[s] = 1;
            queue.addLast(s);
            while (!queue.isEmpty()) {
                int cur = queue.pollFirst();
                int color = colors[cur];
                for (int nxt : graph[cur]) {
                    if (colors[nxt] == 0) {
                        colors[nxt] = -color;
                        queue.addLast(nxt);
                    } else if (colors[nxt] == color) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}