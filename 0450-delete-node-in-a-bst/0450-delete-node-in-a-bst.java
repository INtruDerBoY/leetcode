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

    public TreeNode deleteNode(TreeNode root, int key) {

        // Node not found
        if (root == null) {
            return null;
        }

        // Search left
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }

        // Search right
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }

        // Node found
        else {

            // No left child
            if (root.left == null) {
                return root.right;
            }

            // No right child
            if (root.right == null) {
                return root.left;
            }

            // Two children
            TreeNode successor = findMin(root.right);

            root.val = successor.val;

            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }

    private TreeNode findMin(TreeNode root) {

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }
}