package simple;

/**
 * @author bike
 * @create 2019-04-08 上午9:52
 * <p>
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 **/
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : (1 + Math.max(maxDepth(root.left), maxDepth(root.right)));
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}