import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int countOnes = 0;

        // Count the total number of ones in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                countOnes += grid[i][j] == 1 ? 1 : 0;
            }
        }

        boolean[][] vis = new boolean[n][m];
        int boundOnes = 0;

        // Traverse the first and last rows
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1 && !vis[0][j]) {
                boundOnes += bfs(0, j, grid, vis);
            }
            if (grid[n - 1][j] == 1 && !vis[n - 1][j]) {
                boundOnes += bfs(n - 1, j, grid, vis);
            }
        }

        // Traverse the first and last columns
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1 && !vis[i][0]) {
                boundOnes += bfs(i, 0, grid, vis);
            }
            if (grid[i][m - 1] == 1 && !vis[i][m - 1]) {
                boundOnes += bfs(i, m - 1, grid, vis);
            }
        }

        return countOnes - boundOnes;
    }

    int bfs(int row, int col, int[][] grid, boolean[][] vis) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(row, col));

        vis[row][col] = true;
        int count = 1;
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = node.x + dx[i];
                int y = node.y + dy[i];

                if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && !vis[x][y] && grid[x][y] == 1) {
                    q.add(new Node(x, y));
                    vis[x][y] = true;
                    count++;
                }
            }
        }

        return count;
    }
}

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
