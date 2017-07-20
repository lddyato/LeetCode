/**
 * Created by xjwhhh on 2017/7/20.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class Convert_Sorted_Array_to_Binary_Search_Tree {
    //TODO 过不了，不太了解应该以什么方式组织成树
    public TreeNode sortedArrayToBST(int[] nums) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int length = nums.length;
        TreeNode result = null;
        if (length > 0) {
            TreeNode head = new TreeNode(nums[0]);
            result = head;
            int i = 1;
            while (i < length && head != null) {
                TreeNode left = new TreeNode(nums[i]);
                i++;
                head.left = left;
                queue.add(left);
                if (i < length) {
                    TreeNode right = new TreeNode(nums[i]);
                    i++;
                    head.right = right;
                    queue.add(right);
                }
                head = queue.poll();
            }
        }
        return result;
    }
}
