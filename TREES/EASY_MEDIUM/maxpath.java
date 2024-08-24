class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfsSum(root);
        return maxSum;
    }

    public int dfsSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
       
        int ls = Math.max(0, dfsSum(root.left));
        int rs = Math.max(0, dfsSum(root.right));
        

        maxSum = Math.max(maxSum, ls + rs + root.val);
        

        return root.val + Math.max(ls, rs);
    }
}
