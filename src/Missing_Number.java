import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */

//If the array is in order, I prefer Binary Search method. Otherwise, the XOR method is better.
public class Missing_Number {
    public int missingNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(i)) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 异或运算
     * The basic idea is to use XOR operation. We all know that a^b^b =a, which means two xor operations with the same number will eliminate the number and reveal the original number.
     * In this solution, I apply XOR operation to both the index and value of the array. In a complete array with no missing numbers,
     * the index and value should be perfectly corresponding( nums[index] = index), so in a missing array, what left finally is the missing number.
     *
     * @param nums
     * @return
     */
    public int missingNumber1(int[] nums) {

        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
    }

    //sum，用完整的总和减去已有的得到不存在的
    public int missingNumber2(int[] nums) { //sum
        int len = nums.length;
        int sum = (0 + len) * (len + 1) / 2;
        for (int i = 0; i < len; i++)
            sum -= nums[i];
        return sum;
    }

    //binary search
    public int missingNumber3(int[] nums) {
        Arrays.sort(nums);//先排序才能用二分搜索
        int left = 0, right = nums.length, mid = (left + right) / 2;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] > mid) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        Missing_Number missing_number = new Missing_Number();
        int[] nums = {1, 0};
        int a = missing_number.missingNumber(nums);
        System.out.println(a);
    }
}
