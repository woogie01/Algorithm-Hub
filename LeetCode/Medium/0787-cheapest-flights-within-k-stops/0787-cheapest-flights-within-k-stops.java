class Solution {
   private static final int INF = 1_000_000_000;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 연결관계 입력
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] f : flights) adj[f[0]].add(new int[]{f[1], f[2]});

        // 거리 및 방문 정보를 담는 배열 생성
        int maxStops = k + 1;
        int[][] dist = new int[n][maxStops + 1];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], INF);
        dist[src][0] = 0;

        // 우선순위 큐 (cost 오름차순): [cost, city, stopsUsed]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, src, 0});

        // 탐색 시작
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0];
            int u = cur[1];
            int used = cur[2];

            if (cost > dist[u][used]) continue;
            if (u == dst) return cost;

            if (used < maxStops) {
                for (int[] e : adj[u]) {
                    int v = e[0];
                    int w = e[1];
                    int nextCost = cost + w;
                    if (nextCost < dist[v][used + 1]) {
                        dist[v][used + 1] = nextCost;
                        pq.add(new int[]{nextCost, v, used + 1});
                    }
                }
            }
        }

        return -1;
    }
}