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
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ls=new LinkedList<>();
        Queue<TreeNode> q=new LinkedList<>();
       if(root!=null) q.add(root);
        boolean chk=true;
        while(!q.isEmpty())
        {
            int s=q.size();
            LinkedList list=new LinkedList<>();
            for(int i=0;i<s;i++)
            {
                TreeNode node=q.poll();

               if(node.left!=null) q.add(node.left);
               if(node.right!=null) q.add(node.right);
               if(chk)
               {
           list.add(node.val);
               }
               else{
                          list.add(0,node.val);

               }

            }
            ls.add(list);
            chk=!chk;

        }
        return ls;
        
    }
}