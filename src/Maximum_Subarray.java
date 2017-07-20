/**
 * Created by xjwhhh on 2017/7/20.
 */

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
public class Maximum_Subarray {
    //最大子序列和最佳算法，要注意只有负数的序列
    public int maxSubArray(int[] nums) {
        int max = 0;
        int sum = 0;
        boolean allNeagtive = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                allNeagtive = false;
                break;
            }
        }
        if (!allNeagtive) {
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (sum < 0) {
                    sum = 0;
                } else if (sum > max) {
                    max = sum;
                }
            }
            return max;
        } else {
            max = nums[0];
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
            return max;
        }
    }

    //方法二，brute force 三重循环，对所有的子序列求和，在其中找到最大的

    //方法三，从某点开始的所有序列中，找最大的，二重循环

    public static void main(String[] args) {
        Maximum_Subarray maximum_subarray = new Maximum_Subarray();
        int a = maximum_subarray.maxSubArray(new int[]{-2, -1, -2});
        System.out.print(a);
    }
}
