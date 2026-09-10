/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean exists(TreeNode root, TreeNode node){
        if(node==root) return true;
        if(root==null) return false;
        return exists(root.left,node) ||  exists(root.right,node);

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p==root || q==root) return root;
        // doses p lies in left sub tree;
        boolean pliesInLst= exists(root.left,p);
        boolean qliesInLst=exists(root.left,q);
        
        if(pliesInLst== true && qliesInLst == true ) return lowestCommonAncestor(root.left,p,q);
        if(pliesInLst== false && qliesInLst == false ) return lowestCommonAncestor(root.right,p,q);
        else return root;
    }
}