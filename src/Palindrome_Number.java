import java.util.List;
import java.util.ArrayList;
/**
 * Created by xjwhhh on 2017/7/11.
 */

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class Palindrome_Number {
    //注意边界条件和特例0
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x == 0) {
            return true;
        }
        List<Integer> list = new ArrayList<Integer>();
        while (x > 0) {
            int a = x % 10;
            list.add(a);
            x = (x - a) / 10;
        }
        boolean result = true;
        for (int i = 0; i <= list.size() / 2; i++) {
            if (list.get(i) != list.get(list.size() - i - 1)) {
                result = false;
                break;
            }
        }
        return result;
    }

    //不停地判断前n位与后n位的倒置是否相等
    //要考虑十的倍数，因为尾数为0，除了0 不可能有回文
    public boolean isPalindrome1(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (x == rev || x == rev / 10);
    }

    public static void main(String[] args) {
        Palindrome_Number palindrome_number = new Palindrome_Number();
        boolean result = palindrome_number.isPalindrome(-2147483648);
        System.out.println(result);

    }
}
