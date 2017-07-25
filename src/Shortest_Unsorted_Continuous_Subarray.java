import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
 * You need to find the shortest such subarray and output its length.
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * <p>
 * Note:
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 */

public class Shortest_Unsorted_Continuous_Subarray {
    //应该是错的
//    public int findUnsortedSubarray(int[] nums) {
//        int length=nums.length;
//        int startLength=1;
//        int endLength=1;
//        int startEqual=0;
//        int endEqual=0;
//        for(int i=0;i<nums.length-1;i++){
//            if(nums[i]<nums[i+1]){
//                startLength++;
//            }
//            else if(nums[i]==nums[i+1]){
//                startEqual++;
//            }
//            else{
//                startLength--;
//                break;
//            }
//        }
//        for(int i=nums.length-1;i>0;i--){
//            if(nums[i]>=nums[i-1]){
//                endLength++;
//            }
//            else{
//                endLength--;
//                break;
//            }
//        }
//        int result=length-startLength-endLength;
//        if(result<0){
//            return 0;
//        }
//        else{
//            return result;
//        }
//    }

    public int findUnsortedSubarray(int[] nums) {
        int[] save = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            save[i] = nums[i];
        }
        Arrays.sort(nums);
        int startCount = 0;
        int endCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (save[i] == nums[i]) {
                startCount++;
            } else {
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (save[i] == nums[i]) {
                endCount++;
            } else {
                break;
            }
        }
        int result = nums.length - startCount - endCount;
        if (result < 0) {
            return 0;
        } else {
            return result;
        }
    }

    //brute force1
    public int findUnsortedSubarray1(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j <= nums.length; j++) {
                int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, prev = Integer.MIN_VALUE;
                for (int k = i; k < j; k++) {
                    min = Math.min(min, nums[k]);
                    max = Math.max(max, nums[k]);
                }
                if ((i > 0 && nums[i - 1] > min) || (j < nums.length && nums[j] < max))
                    continue;
                int k = 0;
                while (k < i && prev <= nums[k]) {
                    prev = nums[k];
                    k++;
                }
                if (k != i)
                    continue;
                k = j;
                while (k < nums.length && prev <= nums[k]) {
                    prev = nums[k];
                    k++;
                }
                if (k == nums.length) {
                    res = Math.min(res, j - i);

                }
            }
        }
        return res;
    }

    //brute force2
    public int findUnsortedSubarray2(int[] nums) {
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    r = Math.max(r, j);
                    l = Math.min(l, i);
                }
            }
        }
        return r - l < 0 ? 0 : r - l + 1;
    }

    //sorting
    public int findUnsortedSubarray3(int[] nums) {
        int[] snums = nums.clone();
        Arrays.sort(snums);
        int start = snums.length, end = 0;
        for (int i = 0; i < snums.length; i++) {
            if (snums[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }

    //stack
    public int findUnsortedSubarray4(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
                l = Math.min(l, stack.pop());
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                r = Math.max(r, stack.pop());
            stack.push(i);
        }
        return r - l > 0 ? r - l + 1 : 0;
    }

    //Without Using Extra Space
    public int findUnsortedSubarray5(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                flag = true;
            if (flag)
                min = Math.min(min, nums[i]);
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                flag = true;
            if (flag)
                max = Math.max(max, nums[i]);
        }
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l])
                break;
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r])
                break;
        }
        return r - l < 0 ? 0 : r - l + 1;
    }

    public static void main(String[] args) {
        Shortest_Unsorted_Continuous_Subarray shortest_unsorted_continuous_subarray = new Shortest_Unsorted_Continuous_Subarray();
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        shortest_unsorted_continuous_subarray.findUnsortedSubarray(nums);
    }
}
