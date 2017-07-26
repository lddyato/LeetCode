import java.util.*;

/**
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * Example: 19 is a happy number
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class Happy_Number {
    public boolean isHappy(int n) {
        List<Integer> list = new LinkedList<Integer>();
        boolean result = true;
        while (n != 1) {
            List<Integer> bits = new ArrayList<Integer>();
            while (n > 0) {
                int a = n % 10;
                int b = n / 10;
                bits.add(a);
                n = b;
            }
            int nn = 0;
            for (int i = 0; i < bits.size(); i++) {
                nn += (Math.pow(bits.get(i), 2));
            }
            n = nn;
            if (list.contains(n)) {
                result = false;
                break;
            }
            list.add(n);
        }
        return result;
    }

    /**
     * The idea is to use one hash set to record sum of every digit square of every number occurred. Once the current sum cannot be added to set, return false; once the current sum equals 1, return true;
     *
     * @param n
     * @return
     */
    public boolean isHappy1(int n) {
        Set<Integer> inLoop = new HashSet<Integer>();
        int squareSum, remain;
        while (inLoop.add(n)) {//如果加不进去，就是false
            squareSum = 0;
            while (n > 0) {
                remain = n % 10;
                squareSum += remain * remain;
                n /= 10;
            }
            if (squareSum == 1)
                return true;
            else
                n = squareSum;

        }
        return false;

    }
}
