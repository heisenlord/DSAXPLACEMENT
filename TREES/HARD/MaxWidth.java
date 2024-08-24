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
class A{
    TreeNode root;
    int num;
    A(TreeNode a,int b){
        root=a;
        num=b;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int ans=0;
        if(root==null){
            return 0;
        }
        Queue<A>q=new LinkedList<>();
        q.add(new A(root,0));
        while(!q.isEmpty()){
            int l=q.size();
            int low=Integer.MAX_VALUE;
            int h=Integer.MIN_VALUE;
            for(int i=0;i<l;i++){
                A ne=q.remove();
                int n=ne.num;
                root=ne.root;
                low=Math.min(low,n);
                h=Math.max(h,n);
                if(root.left!=null){
                    q.add(new A(root.left,2*(n-low)+1));
                }
                if(root.right!=null){
                    q.add(new A(root.right,2*(n-low)+2));
                }
            }
            ans=Math.max(ans,h-low+1);
        }
        return ans;
    }
}