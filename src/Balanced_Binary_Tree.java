/**
 * Created by xjwhhh on 2017/7/20.
 */

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class Balanced_Binary_Tree {
    //在遍历树的每个结点的时候，调用函数height得到它的左右子树的深度。
    // 如果每个结点的左右子树的深度相差不超过1，按照定义它就是一棵平衡的二叉树。
    //由于一个结点会被重复遍历多次,效率过低
    public boolean isBalanced(TreeNode root) {
        boolean result = true;
        if (root == null) {
            return true;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }

        boolean booleft = isBalanced(root.left);
        boolean booright = isBalanced(root.right);
        return booleft && booright;

    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }

    //Java solution based on height, check left and right node in every recursion to avoid further useless search
    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return height1(root) != -1;

    }

    public int height1(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int lH = height1(node.left);
        if (lH == -1) {
            return -1;
        }
        int rH = height1(node.right);
        if (rH == -1) {
            return -1;
        }
        if (lH - rH < -1 || lH - rH > 1) {
            return -1;
        }
        return Math.max(lH, rH) + 1;
    }
}
