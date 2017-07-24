import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 */

public class Contains_Duplicate_II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);//始终保持set的大小为k+1
            if(!set.add(nums[i])) return true;//加不进去说明存在一样的值
        }
        return false;
    }

    public static void main(String[] args) {
        Contains_Duplicate_II contains_duplicate_ii = new Contains_Duplicate_II();
        int[] nums = {1, 0, 1, 1};
        int k = 1;
        contains_duplicate_ii.containsNearbyDuplicate(nums, k);
    }

}
