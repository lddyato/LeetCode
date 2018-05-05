import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 * <p>
 * Example:
 * <p>
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note:
 * <p>
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */

public class Group_Anagrams {

    //超时了，将str排序后去找相同键值，比遍历列表块
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        for (String str : strs) {
            boolean isExist = false;
            for (List<String> list : result) {
                if (list.get(0).length() == str.length()) {
                    if (anagram(list.get(0), str)) {
                        list.add(str);
                        isExist = true;
                        break;
                    }
                }
            }
            if (!isExist) {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                result.add(newList);
            }
        }
        return result;
    }

    public boolean anagram(String a, String b) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            hashMap.put(a.charAt(i), hashMap.getOrDefault(a.charAt(i), 0) + 1);
        }
        for (int i = 0; i < b.length(); i++) {
            hashMap.put(b.charAt(i), hashMap.getOrDefault(b.charAt(i), 0) - 1);
        }
        for (Integer charInt : hashMap.values()) {
            if (charInt != 0) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    //把颠倒字符串变成自定义字符串来比较是否相同
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
