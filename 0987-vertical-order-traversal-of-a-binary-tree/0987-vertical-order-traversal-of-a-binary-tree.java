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

    class Pair {
        TreeNode node;
        int row;
        int col;

        Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        // col -> nodes
        TreeMap<Integer, List<Pair>> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0, 0));

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            map.putIfAbsent(curr.col, new ArrayList<>());
            map.get(curr.col).add(curr);

            if (curr.node.left != null) {
                q.add(new Pair(
                    curr.node.left,
                    curr.row + 1,
                    curr.col - 1
                ));
            }

            if (curr.node.right != null) {
                q.add(new Pair(
                    curr.node.right,
                    curr.row + 1,
                    curr.col + 1
                ));
            }
        }

        // Process columns from left to right
        for (List<Pair> list : map.values()) {

            // Sort by row, then value
            Collections.sort(list, (a, b) -> {

                if (a.row != b.row) {
                    return a.row - b.row;
                }

                return a.node.val - b.node.val;
            });

            List<Integer> temp = new ArrayList<>();

            for (Pair p : list) {
                temp.add(p.node.val);
            }

            ans.add(temp);
        }

        return ans;
    }
}