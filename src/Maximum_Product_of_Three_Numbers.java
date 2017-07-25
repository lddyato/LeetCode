import java.util.Arrays;

/**
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 * Example 1:
 * Input: [1,2,3]
 * Output: 6
 * <p>
 * Example 2:
 * Input: [1,2,3,4]
 * Output: 24
 * <p>
 * Note:
 * The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
 * Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 */

public class Maximum_Product_of_Three_Numbers {

    /**
     * Approach #2 Using Sorting [Accepted]
     * Algorithm
     * Another solution could be to sort the given nums array(in ascending order) and find out the product of the last three numbers.
     * But, we can note that this product will be maximum only if all the numbers in nums array are positive. But, in the given problem statement, negative elements could exist as well.
     * Thus, it could also be possible that two negative numbers lying at the left extreme end could also contribute to lead to a larger product if the third number in the triplet being considered is the largest positive number in the nums array.
     * Thus, either the product nums[0]xnums[1]x nums[n−1] or nums[n−3]x nums[n−2]x nums[n−1] will give the required result. Thus, we need to find the larger one from out of these values.
     *
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }

    /**
     * Approach #3 Single Scan [Accepted]
     * Algorithm
     * We need not necessarily sort the given nums array to find the maximum product. Instead, we can only find the required 2 smallest values(
     * min1 and min2) and the three largest values(max1,max2,max3) in the nums array, by iterating over the nums array only once.
     * At the end, again we can find out the larger value out of min1x min2x max1 and max1x max2x max3 to find the required maximum product.
     *
     * @param nums
     * @return
     */
    public int maximumProduct1(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            } else if (n <= min2) {     // n lies between min1 and min2
                min2 = n;
            }
            if (n >= max1) {            // n is greater than max1, max2 and max3
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n >= max2) {     // n lies betweeen max1 and max2
                max3 = max2;
                max2 = n;
            } else if (n >= max3) {     // n lies betwen max2 and max3
                max3 = n;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

}
