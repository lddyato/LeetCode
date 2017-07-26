import java.util.HashMap;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 * For example,
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 * Note:
 * You may assume both s and t have the same length.
 */

public class Isomorphic_Strings {
//    public boolean isIsomorphic(String s, String t) {
//        char[] chars=s.toCharArray();
//        char[] chart=t.toCharArray();
//
//
//    }

    public boolean isIsomorphic2(String s, String t) {
        if (s == null || s.length() <= 1) return true;
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (map.containsKey(a)) {
                if (map.get(a).equals(b))
                    continue;
                else
                    return false;
            } else {
                if (!map.containsValue(b))
                    map.put(a, b);
                else return false;

            }
        }
        return true;

    }

    public boolean isIsomorphic1(String s1, String s2) {
        int[] m = new int[512];
        for (int i = 0; i < s1.length(); i++) {
            //下标是字符的ASCLL码
//            System.out.println(s1.charAt(i));
//            System.out.println(m[s1.charAt(i)]);
            if (m[s1.charAt(i)] != m[s2.charAt(i) + 256]) return false;
            m[s1.charAt(i)] = m[s2.charAt(i) + 256] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Isomorphic_Strings isomorphic_strings = new Isomorphic_Strings();
        isomorphic_strings.isIsomorphic1("abb", "cdd");
    }
}
