class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            // Calculate current width
            int width = right - left;
            // The height of the water is limited by the shorter bar
            int currentHeight = Math.min(height[left], height[right]);
            // Calculate area and update maxWater if current is larger
            int currentArea = width * currentHeight;
            maxWater = Math.max(maxWater, currentArea);

            // Move the pointer pointing to the shorter bar to potentially find a taller bar
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}