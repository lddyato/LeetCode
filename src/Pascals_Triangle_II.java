/**
 * Created by xjwhhh on 2017/7/21.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class Pascals_Triangle_II {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> row = new ArrayList<Integer>();
        for (int i = 0; i <= rowIndex; i++) {
            row.add(0, 1);//加在最前面
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
        }
        System.out.print(row.toString());
        return row;
    }

    public static void main(String[] args) {
        Pascals_Triangle_II pascals_triangle_ii = new Pascals_Triangle_II();
        pascals_triangle_ii.getRow(3);
    }
}
