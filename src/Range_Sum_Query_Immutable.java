/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * <p>
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 */

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Range_Sum_Query_Immutable {
    //cache
    private int[] sum;

    public Range_Sum_Query_Immutable(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

//    private Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
//
//    public NumArray(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            int sum = 0;
//            for (int j = i; j < nums.length; j++) {
//                sum += nums[j];
//                map.put(Pair.create(i, j), sum);
//            }
//        }
//    }
//
//    public int sumRange(int i, int j) {
//        return map.get(Pair.create(i, j));
//    }
}
