/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 */

public class Container_With_Most_Water {
    /**
     * 最初我们考虑的区域构成了最外面的线条。
     * 现在，为了最大化面积，我们需要考虑较大长度的线之间的面积。
     * 如果我们试图从较长的直线向内移动指针，我们将不会获得任何面积的增加，因为它受到较短的线限制。
     * 但是，按照同样的论点，缩短线段的指针可能是有益的，尽管宽度减小了。
     * 这样做是因为通过移动较短的线指针获得的相对较长的线可以克服由宽度减小引起的面积减少。
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxArea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxArea;
    }
}
