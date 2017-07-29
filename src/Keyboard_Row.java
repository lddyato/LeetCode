import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 * Example 1:
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 * <p>
 * Note:
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of alphabet.
 */

public class Keyboard_Row {
    public String[] findWords(String[] words) {
        //给每一行字母设置相同的值
        String[] strs = {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            for (char c : strs[i].toCharArray()) {
                map.put(c, i);//put <char, rowIndex> pair into the map
            }
        }
        List<String> res = new LinkedList<>();
        for (String w : words) {
            if (w.equals("")) continue;
            int index = map.get(w.toUpperCase().charAt(0));
            for (char c : w.toUpperCase().toCharArray()) {
                if (map.get(c) != index) {
                    index = -1; //don't need a boolean flag.
                    break;
                }
            }
            if (index != -1) res.add(w);//if index != -1, this is a valid string
        }
        return res.toArray(new String[0]);
    }

    //完全看不懂
    public String[] findWords1(String[] words) {
        return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
    }

}
