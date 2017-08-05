/**
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 * Please note that the string does not contain any non-printable characters.
 * Example:
 * Input: "Hello, my name is John"
 * Output: 5
 */

public class Number_of_Segments_in_a_String {
    //错的
//    public int countSegments(String s) {
//        if(s.length()==0){
//            return 0;
//        }
//        String[] strs=s.split("\\s+");
//        System.out.println(strs.length);
//        int count=0;
//        for(int i=0;i<s.length();i++){
//            System.out.println(strs[i]);
//            if(strs[i].equals("")){
//                count++;
//            }
//        }
//        return strs.length-count;
//    }

    public int countSegments(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' '))
                res++;
        return res;
    }

    //Java String.trim()返回去掉首尾空格的字符串
    public int countSegments1(String s) {
        String trimmed = s.trim();
        if (trimmed.length() == 0) return 0;
        else return trimmed.split("\\s+").length;
    }

    public static void main(String[] args) {
        String s = "    foo    bar";
        Number_of_Segments_in_a_String number_of_segments_in_a_string = new Number_of_Segments_in_a_String();
        number_of_segments_in_a_string.countSegments(s);
    }
}
