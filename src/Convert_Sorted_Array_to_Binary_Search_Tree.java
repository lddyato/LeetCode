/**
 * Created by xjwhhh on 2017/7/20.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class Convert_Sorted_Array_to_Binary_Search_Tree {
//    //TODO 过不了，不太了解应该以什么方式组织成树
    //错误在于，是一个已经排好序的数组，且要组织成二分搜索树
    //任何节点的键值大于等于该节点左子树中的所有键值，小于等于该节点右子树中的所有键值。
//    public TreeNode sortedArrayToBST(int[] nums) {
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        int length = nums.length;
//        TreeNode result = null;
//        if (length > 0) {
//            TreeNode head = new TreeNode(nums[0]);
//            result = head;
//            int i = 1;
//            while (i < length && head != null) {
//                TreeNode left = new TreeNode(nums[i]);
//                i++;
//                head.left = left;
//                queue.add(left);
//                if (i < length) {
//                    TreeNode right = new TreeNode(nums[i]);
//                    i++;
//                    head.right = right;
//                    queue.add(right);
//                }
//                head = queue.poll();
//            }
//        }
//        return result;
//    }

    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) {
            return null;
        }
        TreeNode head = helper(num, 0, num.length - 1);
        return head;
    }

    public TreeNode helper(int[] num, int low, int high) {
        if (low > high) { // Done
            return null;
        }
        int mid = low + (high-low)/2; // avoids integer overflow
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
    }
}
