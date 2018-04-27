import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * Example 2:
 * <p>
 * Input:
 * s = "wordgoodstudentgoodword",
 * words = ["word","student"]
 * Output: []
 */

public class Substring_with_Concatenation_of_All_Words {
    public List<Integer> findSubstring(String s, String[] words) {
        if (words.length == 0) {
            return new ArrayList<>();
        }
        HashMap<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<Integer> indexes = new ArrayList<>();
        int length = s.length();
        int wordNum = words.length;
        int wordLength = words[0].length();
        for (int i = 0; i < length - wordLength * wordNum + 1; i++) {
            HashMap<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < wordNum) {
                String word = s.substring(i + j * wordLength, i + (j + 1) * wordLength);
                if (count.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    if (seen.get(word) > count.getOrDefault(word, 0)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == wordNum) {
                indexes.add(i);
            }
        }
        return indexes;
    }
}
