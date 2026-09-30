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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> curr = new ArrayList<Integer>();
        right(root,curr,0);
        return curr;
        
    }
    public void  right(TreeNode root,List<Integer> curr,int depth){
       
        if(root == null) return;
        if(depth == curr.size() ){
            curr.add(root.val);
        }
        right(root.right,curr,depth+1);
         right(root.left,curr,depth+1);
    }
}