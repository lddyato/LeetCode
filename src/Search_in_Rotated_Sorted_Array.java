public class Search_in_Rotated_Sorted_Array {
    //二分查找
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[start] <= nums[mid]){
                if (target < nums[mid] && target >= nums[start])
                    end = mid - 1;
                else
                    start = mid + 1;
            }

            if (nums[mid] <= nums[end]){
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }

    //这么暴力的居然也能ac
    public int search1(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(target==nums[i]){
                return i;
            }
        }
        return -1;
    }
}
