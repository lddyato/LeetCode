/**
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 */
public class Rotate_Array {
    //不知道对不对，超时了
    public void rotate(int[] nums, int k) {
        if (k >= nums.length) {
            k = k % nums.length;
        }
        k = nums.length - k - 1;//k=3
        int[] firstnums = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            firstnums[i] = nums[i];
        }
        for (int i = 0; i < nums.length - k - 1; i++) {
            nums[i] = nums[i + k + 1];
        }
        for (int i = nums.length - k - 1; i < nums.length; i++) {
            nums[i] = firstnums[i - nums.length + k + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    //brute force，超时+1
    public void rotate1(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
            for (int t = 0; t < nums.length; t++) {
                System.out.print(nums[t]);
            }
        }

    }

    //We use an extra array in which we place every element of the array at its correct position i.e. the number at index(1+k).
    //Then, we copy the new array to the original one.
    public void rotate2(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    //跳步执行，每次将n/k个数字放到正确的位置，然后将开始位置加一
    public void rotate3(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    /**
     * Algorithm
     * This approach is based on the fact that when we rotate the array k times,k elements from the back end of the array come to the front and the rest of the elements from the front shift backwards.
     * In this approach, we firstly reverse all the elements of the array. Then, reversing the first k elements followed by reversing the rest n−k elements gives us the required result.
     * Let
     * n=7 and k=3.
     * Original List                   : 1 2 3 4 5 6 7
     * After reversing all numbers     : 7 6 5 4 3 2 1
     * After reversing first k numbers : 5 6 7 4 3 2 1
     * After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
     */

    public void rotate4(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Rotate_Array rotate_array = new Rotate_Array();
        int[] nums = {1, 2};
        int k = 3;
        rotate_array.rotate(nums, k);
    }
}
