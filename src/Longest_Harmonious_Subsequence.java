import java.util.HashMap;
import java.util.Map;

/**
 * We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.
 * Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.
 * Example 1:
 * Input: [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 * <p>
 * Note: The length of the input array will not exceed 20,000.
 */

public class Longest_Harmonious_Subsequence {
    //超时，直接判断键值就可以了，不要从最小到最大遍历！
    public int findLHS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int min = nums[0];
        int max = nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (min > nums[i]) {
                min = nums[i];
            }
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        int temp = 0;
        int result = temp;
        for (int i = min; i <= max - 1; i++) {
            if (map.containsKey(i) && map.containsKey(i + 1)) {
                temp = map.get(i) + map.get(i + 1);
                if (temp > result) {
                    result = temp;
                }
            }
        }
        return result;

    }

    public int findLHS1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1))
                res = Math.max(res, map.get(key) + map.get(key + 1));
        }
        return res;
    }

    public int findLHS2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.containsKey(num + 1))
                res = Math.max(res, map.get(num) + map.get(num + 1));
            if (map.containsKey(num - 1))
                res = Math.max(res, map.get(num) + map.get(num - 1));
        }
        return res;
    }

}
