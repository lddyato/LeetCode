/**
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 * <p>
 * Example 1:
 * <p>
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 * <p>
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 * <p>
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * Note:
 * <p>
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−2 31, 2 31 − 1]
 */
public class Pow {
    //负奇数除二余1，负偶数除二余0，要注意n的范围，最小的负数转成正数后不能用int表示
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n % 2 == 0) return myPow(x * x, n / 2);
        else {
            if (n > 0) return x * myPow(x * x, n / 2);
            else return (1 / x) * myPow(x * x, n / 2);
        }
    }

    //把int转为long就没有表示范围的问题了
    public double myPow1(double x, int n) {
        long nn = n;
        return myPow(x, nn);
    }

    private double myPow(double x, long n) {
        if (n == 0) return 1;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

}
