import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static ArrayList<Integer>[] graph;
    static ArrayList<int[]> parties;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int[] truth = new int[T];
        for (int i = 0; i < T; i++) {
            truth[i] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            int[] party = new int[count];
            for (int j = 0; j < count; j++) {
                party[j] = Integer.parseInt(st.nextToken());
            }
            parties.add(party);

            for (int k = 1; k < count; k++) {
                int u = party[k - 1];
                int v = party[k];
                graph[u].add(v);
                graph[v].add(u);
            }
        }

        boolean[] knowTheTruth = spreadTruthBfs(truth);
        int answer = 0;
        Loop:
        for (int[] party : parties) {
            for (int person : party) {
                if (knowTheTruth[person]) continue Loop;
            }
            answer++;
        }
        System.out.println(answer);
    }

    private static boolean[] spreadTruthBfs(int[] truth) {
        boolean[] knowTheTruth = new boolean[N + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int t : truth) {
            knowTheTruth[t] = true;
            queue.addLast(t);
        }

        while (!queue.isEmpty()) {
            int cur = queue.pollFirst();
            for (int person : graph[cur]) {
                if (!knowTheTruth[person]) {
                    knowTheTruth[person] = true;
                    queue.addLast(person);
                }
            }
        }
        return knowTheTruth;
    }
}