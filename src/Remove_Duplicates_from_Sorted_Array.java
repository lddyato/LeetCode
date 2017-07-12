/**
 * Created by xjwhhh on 2017/7/12.
 */

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the new length.
 */
public class Remove_Duplicates_from_Sorted_Array {
    //不仅要返回不重复的数组长度n，还要将数组的前n位转化为不重复的数字（审题！！！）
    public int removeDuplicates(int[] nums) {
        int result = 0;
        int length = nums.length;
        if (length <= 1) {
            return length;
        } else {
            result = 1;
            int j = 0;//当前指针
            for (int i = 1; i < length; i++) {
                if (nums[i] != nums[j]) {
                    j++;
                    result++;
                    nums[j] = nums[i];
                }
            }
            return result;
        }
    }

    public int removeDuplicates1(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i == 0 || n > nums[i - 1])
                nums[i++] = n;
        return i;
    }

    public static void main(String[] args) {
        Remove_Duplicates_from_Sorted_Array remove_duplicates_from_sorted_array = new Remove_Duplicates_from_Sorted_Array();
        int[] a = {1, 1, 2, 2, 3};
        int result = remove_duplicates_from_sorted_array.removeDuplicates(a);
        System.out.print(result);
    }
}
