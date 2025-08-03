import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static char[][] board;
    static final int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static final int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    static Map<String, Integer> counts = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(i, j, new StringBuilder().append(board[i][j]));
            }
        }

        for (int i = 0; i < K; i++) {
            String query = br.readLine();
            bw.write(counts.getOrDefault(query, 0) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 문자열 만들기 DFS
    private static void dfs(int x, int y, StringBuilder sb) {
        String current = sb.toString();
        counts.put(current, counts.getOrDefault(current, 0) + 1);

        if (sb.length() == 5) return;

        for (int dir = 0; dir < 8; dir++) {
            int nx = (x + dx[dir] + N) % N;
            int ny = (y + dy[dir] + M) % M;

            sb.append(board[nx][ny]);
            dfs(nx, ny, sb);
            sb.deleteCharAt(sb.length() - 1); // 백트래킹
        }
    }
}