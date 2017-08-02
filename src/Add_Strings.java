import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * Note:
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */

public class Add_Strings {
    public String addStrings(String num1, String num2) {
        if (num1.equals("0") && num2.equals("0")) {
            return "0";
        }
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int index = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (i >= 0 && j >= 0) {
            int temp1 = Integer.valueOf(num1.charAt(i) - '0');
            int temp2 = Integer.valueOf(num2.charAt(j) - '0');
            int temp = temp1 + temp2 + index;
            if (temp >= 10) {
                list.add(temp % 10);
                index = 1;
            } else {
                list.add(temp % 10);
                index = 0;
            }
            i--;
            j--;
        }
        if (i >= 0) {
            while (i >= 0) {
                int temp1 = Integer.valueOf(num1.charAt(i) - '0');
                int temp = temp1 + index;
                if (temp >= 10) {
                    list.add(temp % 10);
                    index = 1;
                } else {
                    list.add(temp % 10);
                    index = 0;
                }
                i--;
            }
        }
        if (j >= 0) {
            while (j >= 0) {
                int temp2 = Integer.valueOf(num2.charAt(j) - '0');
                int temp = temp2 + index;
                if (temp >= 10) {
                    list.add(temp % 10);
                    index = 1;
                } else {
                    list.add(temp % 10);
                    index = 0;
                }
                j--;
            }
        }
        if (index == 1) {
            list.add(1);
        }
        String result = "";
        for (int m = list.size() - 1; m >= 0; m--) {
            result += list.get(m);
        }
        return result;
    }

    public String addStrings1(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Add_Strings add_strings = new Add_Strings();
        add_strings.addStrings("9", "99");
    }
}
