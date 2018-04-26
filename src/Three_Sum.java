import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets.
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */

public class Three_Sum {

    //超时，但思路应该是对的，使用了2sum的想法
    //查重思路不好
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int one = nums[i];
                Map<Integer, Integer> map = new HashMap<>();
                for (int j = i + 1; j < nums.length; j++) {
                    map.put(j, nums[j]);
                }
                for (int j = i + 1; j < nums.length; j++) {
                    int complement = -one - nums[j];
                    for (Integer key : map.keySet()) {
                        //注意不要用相同的位置的值
                        if (map.get(key) == complement && key > j) {
                            List<Integer> re = new ArrayList<>();
                            re.add(one);
                            re.add(nums[j]);
                            re.add(complement);
                            //查重
                            boolean isexist = false;
                            for (int k = 0; k < result.size(); k++) {
                                List<Integer> test = result.get(k);
                                Map<Integer, Integer> maptest = new HashMap<>();
                                for (int m = 0; m < test.size(); m++) {
                                    maptest.put(test.get(m), maptest.getOrDefault(test.get(m), 0) + 1);
                                }
                                for (int m = 0; m < re.size(); m++) {
                                    maptest.put(re.get(m), maptest.getOrDefault(re.get(m), 0) - 1);
                                }
                                isexist = true;

                                for (Integer keytest : maptest.keySet()) {
                                    if (maptest.get(keytest) != 0) {
                                        isexist = false;
                                        break;
                                    }
                                }
                                if (isexist) {
                                    break;
                                }
                            }
                            if (!isexist) {
                                result.add(re);
                            }
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(result);
        return result;

    }

    /**
     * 排序，先确定第一个，剩下两个从两边向中间逼近
     * 排序之后再判断这个数与前一个数是否相同，相同跳过，使得第一个数不同
     * The idea is to sort an input array and then run through all indices of a possible first element of a triplet.
     * For each possible first element we make a standard bi-directional 2Sum sweep of the remaining part of the array.
     * Also we want to skip equal elements to avoid duplicates in the answer without making a set or smth like that.
     *
     * @param num
     * @return
     */
    public List<List<Integer>> threeSum1(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo + 1]) lo++;//再次跳过相同值
                        while (lo < hi && num[hi] == num[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Three_Sum threeSum = new Three_Sum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        threeSum.threeSum(nums);
    }
}
