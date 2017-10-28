/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital if it has more than one letter, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * <p>
 * Example 1:
 * Input: "USA"
 * Output: True
 * <p>
 * Example 2:
 * Input: "FlaG"
 * Output: False
 * <p>
 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 */

public class Detect_Capital {
    /**
     * The string can be correctly capitalized if either:
     * it's shorter than 2 characters,
     * or if it's all lower case,
     * or if it's all upper case,
     * or if from position 1 onward there are only lowercase letters.
     */
    public boolean detectCapitalUse(String word) {
        if (word.length() < 2) return true;
        if (word.toUpperCase().equals(word)) return true;
        if (word.substring(1).toLowerCase().equals(word.substring(1))) return true;
        return false;
    }

    public boolean detectCapitalUse1(String word) {
        int cnt = 0;
        for (char c : word.toCharArray()) if ('Z' - c >= 0) cnt++;
        return ((cnt == 0 || cnt == word.length()) || (cnt == 1 && 'Z' - word.charAt(0) >= 0));
    }
}
