import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static ArrayList<Integer>[] up;
    static ArrayList<Integer>[] down;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점 개수는 홀수
        M = Integer.parseInt(st.nextToken());

        up = new ArrayList[N + 1];
        down = new ArrayList[N + 1];
        for (int V = 1; V <= N; V++) {
            up[V] = new ArrayList<>();
            down[V] = new ArrayList<>();
        }

        for (int E = 0; E < M; E++) {
            st = new StringTokenizer(br.readLine());
            int heavy = Integer.parseInt(st.nextToken());
            int light = Integer.parseInt(st.nextToken());
            up[light].add(heavy);
            down[heavy].add(light);
        }

        int mid = (N + 1) / 2;
        int answer = 0;
        for (int V = 1; V <= N; V++) {
            int heavyCount = bfs(up, V);
            int lightCount = bfs(down, V);
            if (lightCount >= mid || heavyCount >= mid) answer++;
        }
        System.out.println(answer);
    }

    private static int bfs(ArrayList<Integer>[] graph, int start) {
        boolean[] visit = new boolean[N + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int count = 0;
        visit[start] = true;
        queue.addLast(start);
        while (!queue.isEmpty()) {
            int cur = queue.pollFirst();
            for (int node : graph[cur]) {
                if (!visit[node]) {
                    visit[node] = true;
                    count++;
                    queue.addLast(node);
                }
            }
        }
        return count;
    }
}