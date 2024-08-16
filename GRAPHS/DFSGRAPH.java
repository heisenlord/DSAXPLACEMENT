
class Solution {
    //  return a list 
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V + 1];
        vis[0] = true;
        ArrayList<Integer> ls = new ArrayList<>();
        dfs(0, vis, adj, ls);
        return ls;

    }

    public static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, List<Integer> ls) {
        ls.add(node);
        vis[node] = true;

        for (int i : adj.get(node)) {
            if (!vis[i]) {
                dfs(i, vis, adj, ls);
            }
        }

    }

}
