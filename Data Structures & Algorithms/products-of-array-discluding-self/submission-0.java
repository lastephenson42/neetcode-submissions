class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        int current = 1;

        // caclulate prefix
        for (int i = 0; i < result.length; i++) {
            result[i] *= current;
            current *= nums[i];
        }

        // add in the suffix
        current = 1;
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] *= current;
            current *= nums[i];
        }

        return result;
    }
}