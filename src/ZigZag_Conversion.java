/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * <p>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * <p>
 * 之字形转换
 */
public class ZigZag_Conversion {
    //超时了
    public String convert(String s, int numRows) {
        if (s.equals("")) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        int length = s.length();

        int group = length / (2 * numRows - 2);
        int leftNum = length - group * (2 * numRows - 2);
        int numCols = group * (numRows - 1);
        System.out.println(numCols);
        System.out.println(leftNum);
        if (leftNum <= numRows) {
            numCols++;
            System.out.println("111" + numCols);
        } else {
            numCols++;
//            leftNum-=numRows;
            numCols += (leftNum - numRows);
            System.out.println("222" + numCols);
        }
        int point = 0;
        char[][] array = new char[numRows][numCols];
        if (group > 0) {
            for (int i = 0; i < group; i++) {
                for (int row = 0; row < numRows; row++) {
                    array[row][i * (numRows - 1)] = s.charAt(point);
                    System.out.println("1" + s.charAt(point));
                    point++;

                }
                for (int j = 1; j < numRows - 1; j++) {
                    array[numRows - 1 - j][i * (numRows - 1) + j] = s.charAt(point);
                    System.out.println("2" + s.charAt(point));
                    point++;
                }
            }

            if (leftNum <= numRows) {
                for (int row = 0; row < leftNum; row++) {
                    array[row][group * (numRows - 1)] = s.charAt(point);
                    System.out.println("3" + s.charAt(point));
                    point++;
                }
            } else {
                for (int row = 0; row < numRows; row++) {
                    array[row][group * (numRows - 1)] = s.charAt(point);
                    System.out.println("4" + s.charAt(point));
                    point++;
                }
                leftNum -= numRows;
                for (int j = 1; j <= leftNum; j++) {
                    array[numRows - 1 - j][group * (numRows - 1) + j] = s.charAt(point);
                    System.out.println("5" + s.charAt(point));
                    point++;
                }

            }
        } else {
            for (int row = 0; row < numRows && row < length; row++) {
                array[row][0] = s.charAt(point);
                System.out.println("1" + s.charAt(point));
                point++;

            }
            if (length > numRows) {
                System.out.println("555555");
                for (int j = 1; j <= length - numRows; j++) {
                    array[numRows - 1 - j][j] = s.charAt(point);
                    System.out.println("2" + s.charAt(point));
                    point++;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
//        System.out.println(numRows);
//        System.out.println(numCols);
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (array[i][j] != '\u0000') {
                    stringBuilder.append(array[i][j]);
                    System.out.println(array[i][j]);
                }
            }
        }
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    public String convert1(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = nRows - 2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        System.out.println(sb[0].toString());
        return sb[0].toString();
    }

    public static void main(String[] args) {
        ZigZag_Conversion zigZag_conversion = new ZigZag_Conversion();
        zigZag_conversion.convert1("PAYPALISHIRING", 5);
    }
}
