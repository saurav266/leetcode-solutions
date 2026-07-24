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
        return 1 + Math.max(level(root.left),level(root.right));
    }
    public void level(TreeNode root, int curr, int l, List<Integer> res){
        if(root==null) return;

        if(curr==l){
            res.add(root.val);
        }
        level(root.left, curr+1,l, res);
        level(root.right,curr+1, l, res);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        int n= level(root);
        List<List<Integer>> ans= new ArrayList<>();

        for(int i=1;i<=n;i++){
            List<Integer> res= new ArrayList<>();
            level(root,1,i,res);
            ans.add(res);
        }
        return ans;
    }
}