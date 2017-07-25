/**
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.
 * Example 1:
 * Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 * <p>
 * Note:
 * 1 <= k <= n <= 30,000.
 * Elements of the given array will be in the range [-10,000, 10,000].
 */

public class Maximum_Average_Subarray_I {
    /**
     * 用总和相减获得k个数之和
     * Approach #2 Cumulative Sum [Accepted]
     * Algorithm
     * We know that in order to obtain the averages of subarrays with length k, we need to obtain the sum of these k length subarrays.
     * One of the methods of obtaining this sum is to make use of a cumulative sum array, sum, which is populated only once.
     * Here, sum[i] is used to store the sum of the elements of the given nums array from the first element upto the element at the last index.
     * Once the sum array has been filled up, in order to find the sum of elements from the index i to i+k, all we need to do is to use:
     * sum[i]−sum[i−k]. Thus, now, by doing one more iteration over the sum array, we can determine the maximum average possible from the subarrays of length k.
     * The following animation illustrates the process for a simple example.
     *
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            sum[i] = sum[i - 1] + nums[i];
        double res = sum[k - 1] * 1.0 / k;
        for (int i = k; i < nums.length; i++) {
            res = Math.max(res, (sum[i] - sum[i - k]) * 1.0 / k);
        }
        return res;
    }

    //加一个减一个，获得k个值的总和
    public double findMaxAverage1(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++)
            sum += nums[i];
        double res = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            res = Math.max(res, sum);
        }
        return res / k;
    }

}
