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

import java.util.*;

class Solution {
    private int idx = 0; // global index for preorder traversal

    private TreeNode solve(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) return null;

        int rootVal = preorder[idx];
        idx++;

        // find rootVal in inorder
        int i = start;
        for (; i <= end; i++) {
            if (inorder[i] == rootVal) break;
        }

        TreeNode root = new TreeNode(rootVal);
        root.left = solve(preorder, inorder, start, i - 1);
        root.right = solve(preorder, inorder, i + 1, end);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        idx = 0;
        return solve(preorder, inorder, 0, inorder.length - 1);
    }
}
