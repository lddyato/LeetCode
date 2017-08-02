/**
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 * Given n, find the total number of full staircase rows that can be formed.
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 * Example 1:
 * n = 5
 * <p>
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * <p>
 * Because the 3rd row is incomplete, we return 2.
 * <p>
 * Example 2:
 * n = 8
 * <p>
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * <p>
 * Because the 4th row is incomplete, we return 3.
 */

public class Arranging_Coins {
    //超时
    public int arrangeCoins(int n) {
        int sum = 0;
        int current = 1;
        while (sum <= n) {
            sum += current;
            current++;
        }
        return current - 2;
    }

    /**
     * The idea is about quadratic equation, the formula to get the sum of arithmetic progression is
     * sum = (x + 1) * x / 2
     * so for this problem, if we know the the sum, then we can know the x = (-1 + sqrt(8 * n + 1)) / 2
     *
     * @param n
     * @return
     */
    public int arrangeCoins1(int n) {
        return (int) ((-1 + Math.sqrt(1 + 8 * (long) n)) / 2);
    }

    public int arrangeCoins2(int n) {
        //convert int to long to prevent integer overflow
        long nLong = (long) n;

        long st = 0;
        long ed = nLong;

        long mid = 0;

        while (st <= ed) {
            mid = st + (ed - st) / 2;

            if (mid * (mid + 1) <= 2 * nLong) {
                st = mid + 1;
            } else {
                ed = mid - 1;
            }
        }

        return (int) (st - 1);
    }
}
