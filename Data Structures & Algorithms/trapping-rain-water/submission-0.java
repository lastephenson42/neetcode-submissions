class Solution {
    public int trap(int[] height) {
        // approach 1 - iterate through with 2 points
        // compute maxLeft and maxRight values for each index

        // arrays for precomputed max left & right heights for each index
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        maxLeft[0] = 0;
        maxRight[height.length - 1] = 0;

        // fill the maxLeft & maxRight arrays
        int curMaxLeft = 0, curMaxRight = 0;
        int l = 1, r = height.length - 2;
        while(l < height.length && r >= 0) {
            curMaxLeft = Math.max(maxLeft[l - 1], height[l - 1]);
            curMaxRight = Math.max(maxRight[r + 1], height[r + 1]);
            maxLeft[l] = curMaxLeft;
            maxRight[r] = curMaxRight;
            l++;
            r--;
        }

        // now go through and compute the amount of water present
        int waterArea = 0;
        int temp = 0;
        for (l = 0; l < height.length; l++) {
            temp = (Math.min(maxLeft[l], maxRight[l])) - height[l];
            if (temp > 0) waterArea += temp;
        }

        return waterArea;
    }
}
