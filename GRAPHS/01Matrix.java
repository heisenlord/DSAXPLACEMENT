class Node {
    int i, j, k;

    public Node(int i, int j, int k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Node(i, j, 0));
                    vis[i][j] = true;
                } else {
                    vis[i][j] = false;
                }
            }
        }

        int[] delRows = { -1, 0, 1, 0 };
        int[] delCols = { 0, -1, 0, 1 };

        while (!q.isEmpty()) {
            Node node = q.poll();
            int i = node.i;
            int j = node.j;
            int k = node.k;

            ans[i][j] = k;

            for (int a = 0; a < 4; a++) {
                int row = i + delRows[a];
                int col = j + delCols[a];

                if (row >= 0 && col >= 0 && row < n && col < m && !vis[row][col]) {
                    vis[row][col] = true;
                    q.add(new Node(row, col, k + 1));
                }
            }
        }

        return ans;
    }
}
