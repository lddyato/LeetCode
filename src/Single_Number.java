import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */

public class Single_Number {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

    //known that A XOR A = 0 and the XOR operator is commutative, the solution will be very straightforward.
    public int singleNumber(int A[], int n) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result ^= A[i];
        }
        return result;
    }
}
