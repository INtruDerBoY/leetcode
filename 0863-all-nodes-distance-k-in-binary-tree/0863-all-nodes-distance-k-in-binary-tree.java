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

    public List<Integer> distanceK(
        TreeNode root,
        TreeNode target,
        int k
    ) {

        List<Integer> ans = new ArrayList<>();

        // Step 1: Store parent of every node
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        makeParent(root, parent);

        // Step 2: BFS from target
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.add(target);
        visited.add(target);

        int distance = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            // We reached distance k
            if (distance == k) {

                while (!q.isEmpty()) {
                    ans.add(q.poll().val);
                }

                return ans;
            }

            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();

                // Left child
                if (node.left != null &&
                    !visited.contains(node.left)) {

                    visited.add(node.left);
                    q.add(node.left);
                }

                // Right child
                if (node.right != null &&
                    !visited.contains(node.right)) {

                    visited.add(node.right);
                    q.add(node.right);
                }

                // Parent
                if (parent.containsKey(node)) {

                    TreeNode p = parent.get(node);

                    if (!visited.contains(p)) {

                        visited.add(p);
                        q.add(p);
                    }
                }
            }

            distance++;
        }

        return ans;
    }

    // Create parent map
    void makeParent(
        TreeNode root,
        Map<TreeNode, TreeNode> parent
    ) {

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {

            TreeNode node = q.poll();

            if (node.left != null) {

                parent.put(node.left, node);
                q.add(node.left);
            }

            if (node.right != null) {

                parent.put(node.right, node);
                q.add(node.right);
            }
        }
    }
}