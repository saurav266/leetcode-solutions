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
    public int level(TreeNode root){
        if(root==null) return 0;
        return 1 + Math.max(level(root.left), level(root.right));
    }
    public void helper(TreeNode root,int idx, List<Integer> ans){
        if(root==null) return;
        ans.set(idx,root.val);
        helper(root.left,idx+1,ans);
        helper(root.right,idx+1,ans);


    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans= new ArrayList<>();
        int n=level(root);
        for(int i=1;i<=n;i++){
            ans.add(0);
        }
        helper(root,0,ans);
        return ans;
    }
}