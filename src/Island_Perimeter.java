/**
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 * Example:
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 * <p>
 * Answer: 16
 */

public class Island_Perimeter {
    public int islandPerimeter(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length - 1; i++) {
            int[] first = grid[i];
            int[] next = grid[i + 1];
            for (int j = 0; j < first.length - 1; j++) {
                if (first[j] == 1) {
                    result += 4;
                }
                if (first[j] == 1 && next[j] == 1) {
                    result -= 2;
                }
                if (first[j] == 1 && first[j + 1] == 1) {
                    result -= 2;
                }
            }
            if (first[first.length - 1] == 1) {
                result += 4;
            }
            if (first[first.length - 1] == 1 && next[next.length - 1] == 1) {
                result -= 2;
            }

        }
        int[] last = grid[grid.length - 1];
        for (int i = 0; i < last.length - 1; i++) {
            if (last[i] == 1) {
                result += 4;
            }
            if (last[i] == 1 && last[i + 1] == 1) {
                result -= 2;
            }

        }
        if (last[last.length - 1] == 1) {
            result += 4;
        }
        return result;
    }

    /**
     * loop over the matrix and count the number of islands;
     * if the current dot is an island, count if it has any right neighbour or down neighbour;
     * the result is islands * 4 - neighbours * 2
     *
     * @param grid
     * @return
     */
    public int islandPerimeter1(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }
}
