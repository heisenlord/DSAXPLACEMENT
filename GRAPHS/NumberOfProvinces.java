class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] vis = new boolean[isConnected.length];
        int count = 0;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < isConnected.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        for (int i = 0; i < isConnected.length; i++) {
            if (!vis[i]) {
                count++;

                dfs(i, adj, vis);
            }
        }
        return count;

    }

    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        for (int i : adj.get(node)) {
            if (!vis[i]) {
                dfs(i, adj, vis);
            }
        }
    }
}