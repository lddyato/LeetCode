/**
 * Created by xjwhhh on 2017/7/13.
 */

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * For example,
 * Given s = "Hello World",
 * return 5.
 */
public class Length_of_Last_Word {
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        int length = words.length;
        if (length == 0) {
            return 0;
        } else {
            return words[length - 1].length();
        }
    }

    public int lengthOfLastWord1(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
        //trim()去掉字符串首尾的空格  
    }
}
