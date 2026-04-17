class Solution {
    public int[] twoSum(int[] nums, int target) {
        // iterate over nums with 2 loops
        // check if one number can be added to target with any other number in array
        // if a number in the outer loop doesn't work, don't inlude it in further checks
        // outer loop only uses the 0th to length-2 indices
        // inner loop only uses the 1st to length-1 indeces
        int[] output = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {
            for (int a = i + 1; a < nums.length; a++) {
                if (nums[i] + nums[a] == target) {
                    output[0] = i;
                    output[1] = a;
                }
            }
        }

        return output;
    }
}
