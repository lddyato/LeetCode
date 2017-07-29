import java.util.*;

/**
 * Given an integer array with even length, where different numbers in this array represent different kinds of candies. Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister. Return the maximum number of kinds of candies the sister could gain.
 * Example 1:
 * Input: candies = [1,1,2,2,3,3]
 * Output: 3
 * Explanation:
 * There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
 * Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
 * The sister has three different kinds of candies.
 * <p>
 * Example 2:
 * Input: candies = [1,1,2,3]
 * Output: 2
 * Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1].
 * The sister has two different kinds of candies, the brother has only one kind of candies.
 * <p>
 * Note:
 * The length of the given array is in range [2, 10,000], and will be even.
 * The number in given array is in range [-100,000, 100,000].
 */

public class Distribute_Candies {
    //用HashSet会更好
    public int distributeCandies(int[] candies) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < candies.length; i++) {
            map.put(candies[i], map.getOrDefault(candies[i], 0) + 1);
        }
        if (map.size() < candies.length / 2) {
            return map.size();
        } else {
            return candies.length / 2;
        }
    }

    /**
     * Approach #3 Using sorting[Accepted]
     * Algorithm
     * We can sort the given candies array and find out the elements which are unique by comparing the adjacent elements of the sorted array.
     * For every new element found(which isn't the same as the previous element), we need to update the count.
     * At the end, we can return the required result as min(n/2,count), as discussed in the previous approach.
     *
     * @param candies
     * @return
     */
    public int distributeCandies1(int[] candies) {
        Arrays.sort(candies);
        int count = 1;
        for (int i = 1; i < candies.length && count < candies.length / 2; i++)
            if (candies[i] > candies[i - 1])
                count++;
        return count;
    }

    /**
     * Approach #4 Using set [Accepted]
     * Algorithm
     * Another way to find the number of unique elements is to traverse over all the elements of the given candies array and keep on putting the elements in a set.
     * By the property of a set, it will contain only unique elements.
     * At the end, we can count the number of elements in the set, given by, say count.
     * The value to be returned will again be given by min(count,n/2), as discussed in previous approaches.
     * Here, n refers to the size of the candies array.
     */
    public int distributeCandies2(int[] candies) {
        HashSet<Integer> set = new HashSet<>();
        for (int candy : candies) {
            set.add(candy);
        }
        return Math.min(set.size(), candies.length / 2);
    }

}

