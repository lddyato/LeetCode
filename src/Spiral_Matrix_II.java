/**
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */

public class Spiral_Matrix_II {
    //类似spiral_matrix,只不过一个是查找一个是填充_
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return null;
        }
        int[][] matrix = new int[n][n];
        int mStart = 0, nStart = 0, i;
        int t = 1;
        n--;
        int m = n;
        while (mStart <= m && nStart <= n) {
            for (i = nStart; i <= n; i++, t++)
                matrix[mStart][i] = t;
            mStart++;
            for (i = mStart; i <= m; i++, t++)
                matrix[i][n] = t;
            n--;
            for (i = n; i >= nStart && m >= mStart; i--, t++)
                matrix[m][i] = t;
            m--;
            for (i = m; i >= mStart && n >= nStart; i--, t++)
                matrix[i][nStart] = t;
            nStart++;
        }
        return matrix;
    }
}
