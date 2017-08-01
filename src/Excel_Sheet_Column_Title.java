import java.util.ArrayList;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * For example:
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 */

public class Excel_Sheet_Column_Title {
    public String convertToTitle(int n) {
        ArrayList<String> list = new ArrayList<>();
        while (n > 0) {
            n--;
            list.add(String.valueOf((char) (n % 26 + 'A')));
            n /= 26;
        }
        String result = "";
        for (int i = list.size() - 1; i >= 0; i--) {
            result += list.get(i);
        }
        return result;
    }

    //Instead of 1 -> A, 26 -> Z, we can assume that 0 -> A, 25 -> Z, and then here comes the base 26 representation, it's similar when you convert a number from base 10 to base 2
    public String convertToTitle1(int n) {
        String res = "";
        while (n != 0) {
            char ch = (char) ((n - 1) % 26 + 65);
            n = (n - 1) / 26;
            res = ch + res;
        }
        return res;
    }
}
