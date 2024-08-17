class Solution {
    public void solve(char[][] board) {

        boolean[][] vis = new boolean[board.length][board[0].length];
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O' && !vis[0][i]) {
                dfs(0, i, board, vis);
            }
            if (board[n - 1][i] == 'O' && !vis[n - 1][i]) {
                dfs(n - 1, i, board, vis);
            }
        }

        // Traverse the first and last columns
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O' && !vis[i][0]) {
                dfs(i, 0, board, vis);
            }
            if (board[i][m - 1] == 'O' && !vis[i][m - 1]) {
                dfs(i, m - 1, board, vis);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !vis[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    void dfs(int nx, int ny, char[][] board, boolean[][] vis) {
        vis[nx][ny] = true;
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        for (int i = 0; i < 4; i++) {
            int x = nx + dx[i];
            int y = ny + dy[i];
            if (x >= 0 && y >= 0 && x < board.length && y < board[0].length && board[x][y] != 'X' && !vis[x][y]) {
                dfs(x, y, board, vis);
            }

        }
    }
}