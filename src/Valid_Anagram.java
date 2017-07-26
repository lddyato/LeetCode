import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.
 Note:
 You may assume the string contains only lowercase alphabets.
 Follow up:
 What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */

public class Valid_Anagram {
    //错误的，有一个超长的用例过不了，还有就是在覆盖map的值时要注意键是对象，对象的相等判断是复杂的
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        boolean result=true;
        Map<Integer,Integer> maps=new HashMap<Integer,Integer>();
        Map<Integer,Integer> mapt=new HashMap<Integer,Integer>();
        for(int i=0;i<s.length();i++){
            maps.put(Integer.valueOf(s.charAt(i)-'a'),maps.getOrDefault(Integer.valueOf(s.charAt(i)-'a'),0)+1);
        }
        for(int i=0;i<t.length();i++){
            mapt.put(Integer.valueOf(t.charAt(i)-'a'),mapt.getOrDefault(Integer.valueOf(t.charAt(i)-'a'),0)+1);
        }

        for(Map.Entry<Integer,Integer> entry:maps.entrySet()){
            if(!(mapt.containsKey(entry.getKey())&&mapt.get(entry.getKey())==entry.getValue())){
                result=false;
                break;
            }
        }
        return result;
    }

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String [] args){
        Valid_Anagram valid_anagram=new Valid_Anagram();
        boolean re =valid_anagram.isAnagram("aacct","cttca");
        System.out.println(re);
    }
}
