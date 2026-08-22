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
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<>();
        int level=0;
        q.add(root);
        while(!q.isEmpty()){
            if(root==null) return 0;
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode curr=q.poll();
                if(curr.left!=null) {
                q.add(curr.left);}
                if(curr.right!=null){ 
                q.add(curr.right);}
            }
            level++;
        }
        return level;
    }
}