import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
 Example 1:
 Input: [3, 2, 1]

 Output: 1

 Explanation: The third maximum is 1.

 Example 2:
 Input: [1, 2]

 Output: 2

 Explanation: The third maximum does not exist, so the maximum (2) is returned instead.

 Example 3:
 Input: [2, 2, 3, 1]

 Output: 1

 Explanation: Note that the third maximum here means the third maximum distinct number.
 Both numbers with value 2 are both considered as second maximum.
 */

public class Third_Maximum_Number {
    public int thirdMax(int[] nums) {
        //先找到最小的作为初始值
        int min=nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]<min){
                min=nums[i];
            }
        }
        int max1=min;
        int max2=min;
        int max3=min;
        int count1=0;
        int count2=0;
        int count3=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==max1||nums[i]==max2||nums[i]==max3){
            }
            else if(nums[i]>max1){
                max3=max2;
                max2=max1;
                max1=nums[i];
                count1++;
            }
            else if(nums[i]>max2){
                max3=max2;
                max2=nums[i];
                count2++;
            }
            else if(nums[i]>max3){
                max3=nums[i];
                count3++;
            }

        }
        //判断是否存在第三大的
        if(count1+count2+count3>=2){
            return max3;
        }
        else{
            return max1;
        }
    }

    //与第一个方法相比，判断比较好做，初始值也可以直接设为null
    public int thirdMax1(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }

    /**
     * PriorityQueue会对入队的元素进行排序，所以在队列顶端的总是最小的元素,但内部的其它元素的顺序却随着元素的减少始终处于变化之中
     * @param nums
     * @return
     */
    public int thirdMax2(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.contains(i)) {
                pq.offer(i);
                set.add(i);
                if (pq.size() > 3) {
                    set.remove(pq.poll());
                }
            }
        }
        if (pq.size() < 3) {
            while (pq.size() > 1) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
