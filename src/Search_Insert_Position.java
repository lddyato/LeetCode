/**
 * Created by xjwhhh on 2017/7/13.
 */

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */
public class Search_Insert_Position {
    public int searchInsert(int[] nums, int target) {
        int result = 0;
        boolean ismax = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) {
                result = i;
                ismax = false;
                break;
            }
        }
        if (ismax) {
            if (nums[nums.length - 1] != target) {
                return nums.length;
            } else {
                return nums.length - 1;
            }
        } else {
            if (result > 0) {
                if (nums[result - 1] != target) {
                    return result;
                } else {
                    return result - 1;
                }
            } else {
                return result;
            }
        }
    }

    //二分法
    public int searchInsert1(int[] A, int target) {
        int low = 0, high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == target) return mid;
            else if (A[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) {
        Search_Insert_Position search_insert_position = new Search_Insert_Position();
        int[] nums = {1, 3, 5, 6};
        int target = 0;
        int result = search_insert_position.searchInsert(nums, target);
        System.out.print(result);
    }
}
