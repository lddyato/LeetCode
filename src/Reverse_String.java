/**
 * Write a function that takes a string as input and returns the string reversed.
 * Example:
 * Given s = "hello", return "olleh".
 */

public class Reverse_String {
    //超时
    public String reverseString(String s) {
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            result += s.charAt(i);
        }
        return result;
    }

    //use StringBuilder
    public String reverseString1(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    //method 2: use swap method,两边交换
    public String reverseString2(String s) {
        if (s == null || s.length() == 0)
            return "";
        char[] cs = s.toCharArray();
        int begin = 0, end = s.length() - 1;
        while (begin <= end) {
            char c = cs[begin];
            cs[begin] = cs[end];
            cs[end] = c;
            begin++;
            end--;
        }

        return new String(cs);
    }
}
