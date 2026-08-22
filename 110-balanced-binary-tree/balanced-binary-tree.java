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
    public boolean isBalanced(TreeNode root) {
        return dfs(root)!=-1;
    }

        public int dfs(TreeNode node)
        {
            if(node==null) return 0;
            int hleft=dfs(node.left);
            if(hleft==-1) return -1;
            int hright=dfs(node.right);
            if(hright==-1) return -1;
            if (Math.abs(hleft- hright) > 1)  
            return -1;
            return Math.max(hleft,hright)+1;
        }
    }