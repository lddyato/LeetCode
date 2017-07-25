/**
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: True
 * <p>
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: False
 * <p>
 * Note:
 * The input array won't violate no-adjacent-flowers rule.
 * The input array size is in the range of [1, 20000].
 * n is a non-negative integer which won't exceed the input array size.
 */

public class Can_Place_Flowers {
    //要考虑开头结尾！！！
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int result = 0;
        int start = 0;
        for (int i = 0; i < flowerbed.length; i++) {

            if (flowerbed[i] == 0) {
                count++;
            } else {
                if (start == 0) {
                    count -= 1;
                } else {
                    count -= 2;
                }
                result += ((count + 1) / 2);
                count = 0;
                start++;
            }
        }

        if (count == flowerbed.length) {
            result += ((count + 1) / 2);
        } else {
            count -= 1;
            result += ((count + 1) / 2);
        }
        return result >= n;
    }

    //Single Scan,顺序查询，会改0为1，来判断
    public boolean canPlaceFlowers1(int[] flowerbed, int n) {
        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
            i++;
        }
        return count >= n;
    }

    //Optimized
    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i++] = 1;
                count++;
            }
            if (count >= n)
                return true;
            i++;
        }
        return false;
    }

    //

    public static void main(String[] aegs) {
        Can_Place_Flowers can_place_flowers = new Can_Place_Flowers();
        int[] nums = {0};
        int n = 1;
        System.out.println(can_place_flowers.canPlaceFlowers(nums, n));
    }
}
