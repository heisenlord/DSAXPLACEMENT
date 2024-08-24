
class Tuple{
    int x;
    int y;
    Node node;
    public Tuple(int x,int y,Node node)
    {
        this.x=x;
        this.y=y;
        this.node=node;
    }
}
class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        Queue<Tuple> q=new LinkedList<>();
        if(root!=null)q.add(new Tuple(0,0,root));
        while(!q.isEmpty())
        {
            Tuple tup=q.poll();
            int x=tup.x;
            int y=tup.y;
            Node node=tup.node;
            if(!map.containsKey(x))
            {
                map.put(x,node.data);
            }
            if(node.left!=null)q.add(new Tuple(x-1,y+1,node.left));
            if(node.right!=null)q.add(new Tuple(x+1,y+1,node.right));
        }
        ArrayList<Integer> ls=new ArrayList<>();
        for(int i:map.values())
        {
            ls.add(i);
        }
        return ls;
        
    }
}