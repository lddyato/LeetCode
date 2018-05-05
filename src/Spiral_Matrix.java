import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 * <p>
 * Input:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

public class Spiral_Matrix {
    //todo 看官方解答
//    public List<Integer> spiralOrder(int[][] matrix) {
//        List<Integer> result=new ArrayList<>();
//        if(matrix==null||matrix.length==0){
//            return result;
//        }
//    }

    //注意边界
    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if (matrix.length == 0)
            return list;
        int m = matrix.length - 1, n = matrix[0].length - 1;
        int mStart = 0, nStart = 0, i;
        while (mStart <= m && nStart <= n) {
            for (i = nStart; i <= n; i++)
                list.add(matrix[mStart][i]);
            mStart++;
            for (i = mStart; i <= m; i++)
                list.add(matrix[i][n]);
            n--;
            for (i = n; i >= nStart && m >= mStart; i--)
                list.add(matrix[m][i]);
            m--;
            for (i = m; i >= mStart && n >= nStart; i--)
                list.add(matrix[i][nStart]);
            nStart++;
        }
        return list;

    }

}
