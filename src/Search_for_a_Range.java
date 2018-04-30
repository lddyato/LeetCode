/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */

public class Search_for_a_Range {
    public int[] searchRange(int[] nums, int target) {
        int[] result={-1,-1};
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                result[0]=i;
                int j=i;
                while(j<nums.length&&nums[j]==target){
                    j++;
                }
                j--;
                result[1]=j;
                break;
            }
        }
        return result;
    }

    public int[] searchRange1(int[] nums, int target) {
        int[] result={-1,-1};
        int start=0;
        int end=nums.length-1;
        while (start <= end) {
            int mid = (start + end) / 2;
            System.out.println("m"+mid);
            if (nums[mid] == target){
                int i=mid;
                int j=mid;
                while(i>=start&&nums[i]==target){
                    i--;
                }
                i++;
                while(j<=end&&nums[j]==target){
                    j++;
                }
                j--;
                result[0]=i;
                result[1]=j;
                break;
            }
            else if(nums[mid] > target){
                end=mid-1;
                System.out.println("e"+end);
            }else{

                start=mid+1;
                System.out.println("s"+start);
            }
        }
        return result;
    }

    // 官方解答，二分查找
    // returns leftmost (or rightmost) index at which `target` should be
    // inserted in sorted array `nums` via binary search.
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo+hi)/2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }

        return lo;
    }

    public int[] searchRange2(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

        return targetRange;
    }

    public static void main(String[] args){
        Search_for_a_Range a_range=new Search_for_a_Range();
        int[] aa={5,7,7,8,8,10};
        a_range.searchRange1(aa,8);
    }
}
