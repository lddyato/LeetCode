import java.util.ArrayList;

/**
 * Discuss
 * Pick One
 * <p>
 * <p>
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
 * Example 1:
 * Input:
 * 3
 * <p>
 * Output:
 * 3
 * <p>
 * Example 2:
 * Input:
 * 11
 * <p>
 * Output:
 * 0
 * <p>
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 */

public class Nth_Digit {
    //超时
    public int findNthDigit(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            int save = i;
            while (save > 0) {
                int temp = save % 10;
                list.add(temp);
                save /= 10;
            }
            for (int j = list.size() - 1; j >= 0; j--) {
                count++;
                if (count == n) {
                    return list.get(j);
                }
            }
        }
        return 0;
    }

    /**
     * Straight forward way to solve the problem in 3 steps:
     * find the length of the number where the nth digit is from
     * find the actual number where the nth digit is from
     * find the nth digit and return
     *
     * @param n
     * @return
     */
    public int findNthDigit1(int n) {
        int len = 1;
        long count = 9;
        int start = 1;

        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }

        start += (n - 1) / len;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }

    /**
     * Using divisions instead of multiplications to prevent overflow.
     *
     * @param n
     * @return
     */
    public int findNthDigit2(int n) {
        n -= 1;
        int digits = 1, first = 1;
        while (n / 9 / first / digits >= 1) {
            n -= 9 * first * digits;
            digits++;
            first *= 10;
        }
        return (first + n / digits + "").charAt(n % digits) - '0';
    }

    public static void main(String[] args) {
        Nth_Digit nth_digit = new Nth_Digit();
        nth_digit.findNthDigit(3);
    }
}
