class Solution {
    public int maxArea(int[] heights) {
        
        int l = 0;
        int r = heights.length - 1;
        int waterArea = 0, maxWaterArea = 0, minHeight = 0;

        while(l < r) {
            minHeight = Math.min(heights[l], heights[r]);
            waterArea =  minHeight * (r-l);
            maxWaterArea = (maxWaterArea > waterArea) ? maxWaterArea : waterArea;

            if (heights[l] == minHeight) l++;
            else r--;
        }

        return maxWaterArea;
    }
}
