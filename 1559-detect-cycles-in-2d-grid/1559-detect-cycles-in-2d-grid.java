class Solution {
    public boolean containsCycle(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (!visited[r][c]) {
                    // Start DFS: current (r, c), parent (-1, -1)
                    if (dfs(grid, visited, r, c, -1, -1, grid[r][c])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, boolean[][] visited, int r, int c, int pr, int pc, char target) {
        visited[r][c] = true;

        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            // 1. Stay within bounds
            // 2. Only move to the same character
            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == target) {
                
                // If the neighbor is already visited and is NOT our parent, it's a cycle
                if (visited[nr][nc] && (nr != pr || nc != pc)) {
                    return true;
                }
                
                // If not visited, recurse
                if (!visited[nr][nc]) {
                    if (dfs(grid, visited, nr, nc, r, c, target)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}