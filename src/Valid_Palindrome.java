/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 */

public class Valid_Palindrome {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        //java.lang.Character.isLetterOrDigit(int codePoint) 确定指定字符(Unicode代码点)是一个字母或数字。
        while (start < end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } else if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            //toLowerCase() 方法用于将大写字符转换为小写。返回转换后字符的小写形式，如果有的话；否则返回字符本身。
            else {
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

    //先用正则表达式替换，然后判断翻转后的string与原来是否相同
    public boolean isPalindrome1(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }
}
