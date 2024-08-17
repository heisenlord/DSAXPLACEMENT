
class Node{
    int curr;
    int prev;
    public Node(int curr,int prev)
    {
        this.curr=curr;
        this.prev=prev;
    }
    
}
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean checkCycle(boolean[] vis,int node,ArrayList<ArrayList<Integer>>adj)
    {
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(node,-1));
        vis[node]=true;
        while(!q.isEmpty())
        {
            Node nde=q.poll();
            int curr=nde.curr;
            int prev=nde.prev;
            for(int i:adj.get(curr))
            {
                if(!vis[i])
                {
                    q.add(new Node(i,curr));
                    vis[i]=true;
                }else if(prev!=i)
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean[] vis=new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(!vis[i])
            {
                if(checkCycle(vis,i,adj))
                    return true;
            }
        }
        return false;
    }
}