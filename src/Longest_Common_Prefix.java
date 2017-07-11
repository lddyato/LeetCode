/**
 * Created by xjwhhh on 2017/7/11.
 */

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        String pre = strs[0];//公共前缀，最大有可能是第一个字符串本身
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0)//indexof()搜索在该字符串上是否出现了作为参数传递的字符串,如果找到字符串,则返回字符的起始位置
                pre = pre.substring(0,pre.length()-1);
            i++;
        }
        return pre;
    }
}
