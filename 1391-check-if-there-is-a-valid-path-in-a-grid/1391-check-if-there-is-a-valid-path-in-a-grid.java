class Solution {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] move = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        int[] opp    = {1, 0, 3, 2};
        int[][] streets = {
            {},
            {0, 1},
            {2, 3},
            {0, 3},
            {1, 3},
            {0, 2},
            {1, 2},
        };

        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1];

            if (r == m - 1 && c == n - 1) return true;

            for (int d : streets[grid[r][c]]) {
                int nr = r + move[d][0];
                int nc = c + move[d][1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if (visited[nr][nc]) continue;

                boolean connected = false;
                for (int nd : streets[grid[nr][nc]]) {
                    if (nd == opp[d]) { connected = true; break; }
                }

                if (connected) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        return visited[m - 1][n - 1];
    }
}