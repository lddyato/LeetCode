import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

/**
 * 参考了3sum的算法，要注意的是可以有重复的数字
 */
public class Three_Sum_Closest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                int temp = nums[lo] + nums[hi] + nums[i];
                if (temp == target) {
                    return target;
                }
                if (Math.abs(temp - target) < diff) {
                    diff = Math.abs(temp - target);
                    result = temp;
                }
                if (temp < target) {
                    lo++;
                } else if (temp > target) {
                    hi--;
                }
            }
        }
        return result;
    }

}
