import java.util.*;

class Solution {
   static class Position {
        final int y;
        final int x;
        final int dist;

        Position(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }

    // 상, 하, 좌, 우
    private static final int[][] DIRS = { {-1,0}, {1,0}, {0,-1}, {0,1} };

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        // 벽: 0, 길: 1
        boolean[][] visited = new boolean[n][m];
        Queue<Position> q = new ArrayDeque<>();

        if (maps[0][0] == 0) return -1; // 시작이 벽이면 종료
        visited[0][0] = true;
        q.add(new Position(0, 0, 1));   

        while (!q.isEmpty()) {
            Position cur = q.poll();

            // 목표 지점이면 즉시 반환 (최단 거리)
            if (cur.y == n - 1 && cur.x == m - 1) {
                return cur.dist;
            }

            for (int[] d : DIRS) {
                int ny = cur.y + d[0];
                int nx = cur.x + d[1];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue; // 범위 밖
                if (maps[ny][nx] == 0) continue;                      // 벽
                if (visited[ny][nx]) continue;                        // 이미 방문

                visited[ny][nx] = true;
                q.add(new Position(ny, nx, cur.dist + 1));
            }
        }

        return -1; // 도달 불가
    }
}