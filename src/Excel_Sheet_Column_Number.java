/**
 * Related to question Excel Sheet Column Title
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * For example:
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 */

public class Excel_Sheet_Column_Number {
    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            double a = (Integer.valueOf(temp - 'A') + 1) * Math.pow(26, s.length() - 1 - i);
            result += a;
        }
        return result;
    }

    public int titleToNumber1(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); result = result * 26 + (s.charAt(i) - 'A' + 1), i++) ;
        return result;
    }
}
