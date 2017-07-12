/**
 * Created by xjwhhh on 2017/7/12.
 */

/**
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class Implement_strStr {
    public int strStr(String haystack, String needle) {
        int length1 = haystack.length();
        int length2 = needle.length();
        if (length1 < length2) {
            return -1;
        } else if (length2 == 0) {
            return 0;
        } else {
            for (int i = 0; i <= length1 - length2; i++) {
                if (haystack.substring(i, i + length2).equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }

    //KMP algorithms
    public String strStr1(String haystack, String needle) {
        if (needle.equals("")) return haystack;
        if (haystack.equals("")) return null;
        char[] arr = needle.toCharArray();
        int[] next = makeNext(arr);

        for (int i = 0, j = 0, end = haystack.length(); i < end; ) {
            if (j == -1 || haystack.charAt(i) == arr[j]) {
                j++;
                i++;
                if (j == arr.length) return haystack.substring(i - arr.length);
            }
            if (i < end && haystack.charAt(i) != arr[j]) j = next[j];
        }
        return null;
    }

    private int[] makeNext(char[] arr) {
        int len = arr.length;
        int[] next = new int[len];

        next[0] = -1;
        for (int i = 0, j = -1; i + 1 < len; ) {
            if (j == -1 || arr[i] == arr[j]) {
                next[i + 1] = j + 1;
                if (arr[i + 1] == arr[j + 1]) next[i + 1] = next[j + 1];
                i++;
                j++;
            }
            if (arr[i] != arr[j]) j = next[j];
        }

        return next;
    }

    //brute-force
    public int strStr2(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }

}
