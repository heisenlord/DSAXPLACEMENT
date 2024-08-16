
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, -1, adj, vis))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(int node, int par, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        for (int i : adj.get(node)) {
            if (!vis[i]) {
                if (dfs(i, node, adj, vis)) {
                    return true;
                }
            } else if (i != par) {
                return true;
            }
        }
        return false;
    }

}