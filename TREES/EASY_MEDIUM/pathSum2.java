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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res=new LinkedList<>();
        List<Integer> curPath=new LinkedList<>();
        dfs(root,targetSum,curPath,res);
        return res;

    }
    void dfs(TreeNode root,int targetSum,List<Integer> curpath,List<List<Integer>> res)
    {
        if(root==null)
        {
            return;
        }
                    curpath.add(root.val);

        if(root.left==null&&root.right==null&&root.val==targetSum)
        {
            res.add(new LinkedList<>(curpath));
        }else{
            dfs(root.left,targetSum-root.val,curpath,res);
            dfs(root.right,targetSum-root.val,curpath,res);


        }
        curpath.remove(curpath.size()-1);
    }

}