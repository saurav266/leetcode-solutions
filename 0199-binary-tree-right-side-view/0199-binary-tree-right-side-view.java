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
    public List<Integer> rightSideView(TreeNode root) {
        int lvl=level(root);
        List<Integer> ans= new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            TreeNode node=null;
            for (int i = 0; i < n; i++) {
                node = q.poll(); // ✅ use poll()
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            ans.add(node.val);
        }
        return ans;
    }
}