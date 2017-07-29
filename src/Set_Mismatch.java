import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/**
 * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.
 * Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.
 * Example 1:
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 * <p>
 * Note:
 * The given array size will in the range [2, 10000].
 * The given array's numbers won't have any order.
 */

public class Set_Mismatch {
    //错误，没有考虑被替换的在前面的情况
    public int[] findErrorNums(int[] nums) {
        int temp1 = 0;
        int temp2 = 1;
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == temp1) {
                result[0] = temp1;
                if (i == nums.length - 1) {
                    result[1] = temp1 + 1;
                }
                continue;
            }
            if (nums[i] != temp2) {
                result[1] = temp2;
            }
            temp1++;
            temp2++;
        }
        return result;
    }

    public int[] findErrorNums1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int duplicate = 0, n = nums.length;
        long sum = (n * (n + 1)) / 2;
        for (int i : nums) {
            if (set.contains(i)) duplicate = i;
            sum -= i;
            set.add(i);
        }
        return new int[]{duplicate, (int) sum + duplicate};
    }

    public static int[] findErrorNums2(int[] nums) {
        int[] res = new int[2];
        for (int i : nums) {
            if (nums[Math.abs(i) - 1] < 0) res[0] = Math.abs(i);
            else nums[Math.abs(i) - 1] *= -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) res[1] = i + 1;
        }
        return res;
    }

    public int[] findErrorNums3(int[] nums) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] - 1 != i && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                result[0] = nums[i];
                result[1] = i + 1;
                break;
            }
        }

        return result;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int[] findErrorNums4(int[] nums) {
        int[] arr = new int[nums.length + 1];
        int a = 0, b = arr.length;
        for (int i : nums) arr[i]++;

        for (int j = 1; j < arr.length; j++) {
            if (arr[j] == 2) a = j;
            if (arr[j] == 0) b = j;
        }
        return new int[]{a, b};
    }

    public int[] findErrorNums5(int[] nums) {
        BitSet bs = new BitSet(nums.length + 1);
        int a = 0;
        for (int i : nums) {
            if (bs.get(i)) a = i;
            bs.set(i);
        }
        return new int[]{a, bs.nextClearBit(1)};
    }
}
