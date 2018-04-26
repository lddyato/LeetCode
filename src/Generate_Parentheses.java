import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class Generate_Parentheses {
    //用的递归，但击败的很少，可以看看官方解答
    public static List<String> generateParenthesis(int n) {
        Set<String> stringSet = helper(n);
        return new LinkedList<String>(stringSet);
    }

    public static Set<String> helper(int n) {
        Set<String> stringSet = new HashSet<>();
        if (n == 1) {
            stringSet.add("()");
            return stringSet;
        } else {
            Set<String> preStringSet = helper(n - 1);
            for (String str : preStringSet) {
                char[] chars = str.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int j = 0; j < i; j++) {
                        stringBuilder.append(chars[j]);
                    }
                    stringBuilder.append("()");
                    for (int j = i; j < chars.length; j++) {
                        stringBuilder.append(chars[j]);
                    }
                    stringSet.add(stringBuilder.toString());
                }
            }
        }
        return stringSet;
    }

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        for (String s : strings) {
            System.out.println(s);
        }
    }

}
