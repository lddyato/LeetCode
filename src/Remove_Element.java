/**
 * Created by xjwhhh on 2017/7/12.
 */

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * Example:
 * Given input array nums = [3,2,2,3], val = 3
 * Your function should return length = 2, with the first two elements of nums being 2.
 */
public class Remove_Element {
    //去除与val相等的数字，返回不相等的个数n,前n个都是原来不相等的
    public int removeElement(int[] nums, int val) {
        int pointer = 0;
        for (int n : nums) {
            if (n != val) {
                nums[pointer++] = n;
            }
        }
        return pointer;
    }
}
