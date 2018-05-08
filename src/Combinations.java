import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * Example:
 * <p>
 * Input: n = 4, k = 2
 * Output:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n == 0 || k == 0 || n < k) {
            return result;
        }
        if (n == k) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }
            result.add(list);
            return result;
        }
        recursive(result, new ArrayList<>(), 1, n, k);
        return result;

    }

    private void recursive(List<List<Integer>> result, List<Integer> list, int start, int end, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= end; i++) {
            list.add(i);
            recursive(result, list, i + 1, end, k - 1);
            list.remove(list.size() - 1);
        }
    }
}
