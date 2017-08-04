import java.util.HashMap;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * Each letter in the magazine string can only be used once in your ransom note.
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */

public class Ransom_Note {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int count = map.getOrDefault(ransomNote.charAt(i), 0) - 1;
            if (count < 0) {
                return false;
            }
            map.put(ransomNote.charAt(i), count);
        }
        return true;
    }
}
