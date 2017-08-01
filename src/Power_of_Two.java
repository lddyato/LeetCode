/**
 * Given an integer, write a function to determine if it is a power of two.
 */

public class Power_of_Two {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    /**
     * 还有几种方法不太懂
     */
}
