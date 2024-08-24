/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Tuple{
    int x;
    int y;
    TreeNode node;
    public Tuple(int x,int y,TreeNode node)
    {
        this.x=x;
        this.y=y;
        this.node=node;
    }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<Tuple> q=new LinkedList<>();
        if(root!=null)q.add(new Tuple(0,0,root));

        while(!q.isEmpty())
        {
            

                Tuple tup=q.poll();
                int x=tup.x;
                int y=tup.y;
                TreeNode node=tup.node;
                if(!map.containsKey(x))
                {
                    map.put(x,new TreeMap<>());
                }
                if(!map.get(x).containsKey(y))
                {
                    map.get(x).put(y,new PriorityQueue<>());
                }
                map.get(x).get(y).offer(node.val);
                if(node.left!=null)
                {
                    q.add(new Tuple(x-1,y+1,node.left));
                }
                if(node.right!=null)
                {
                    q.add(new Tuple(x+1,y+1,node.right));
                }
                
            
        }
        System.out.println(map);
        List<List<Integer>> ls=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> ys:map.values())
        {
            ls.add(new ArrayList<>());
            for(PriorityQueue<Integer> val:ys.values())
            {
                while(!val.isEmpty())
                {
                ls.get(ls.size()-1).add(val.poll());
                }


            }
        }
        return ls;

        
    }
}