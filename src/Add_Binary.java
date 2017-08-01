import java.util.ArrayList;

/**
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */

public class Add_Binary {
    public String addBinary(String a, String b) {
        char[] chara = a.toCharArray();
        char[] charb = b.toCharArray();
        ArrayList<Integer> list = new ArrayList<>();
        int i = chara.length - 1;
        int j = charb.length - 1;
        int index = 0;
        while (j >= 0 && i >= 0) {
            int tempa = Integer.valueOf(chara[i] - '0');
            int tempb = Integer.valueOf(charb[j] - '0');
            list.add((tempa + tempb + index) % 2);
            if (tempa + tempb + index >= 2) {
                index = 1;
            } else {
                index = 0;
            }
            i--;
            j--;
        }
        if (i >= 0) {
            while (i >= 0) {
                int tempa = Integer.valueOf(chara[i] - '0');
                list.add((tempa + index) % 2);
                if (tempa + index >= 2) {
                    index = 1;
                } else {
                    index = 0;
                }
                i--;
            }
        }
        if (j >= 0) {
            while (j >= 0) {
                int tempb = Integer.valueOf(charb[j] - '0');
                list.add((tempb + index) % 2);
                if (tempb + index >= 2) {
                    index = 1;
                } else {
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
            result += String.valueOf(list.get(m));
        }
        return result;
    }

    public String addBinary1(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Add_Binary add_binary = new Add_Binary();
        String a = "11";
        String b = "1";
        add_binary.addBinary(a, b);
    }
}
