class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        Arrays.sort(nums);

        int i, j, k, threeSum = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i - 1] == nums[i]) continue;

            j = i + 1;
            k = nums.length - 1;
            while (j < k) {
                threeSum = nums[i] + nums[j] + nums[k];
                
                if (threeSum == 0) {
                    out.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    while (--k > j && nums[k] == nums[k + 1]) {}
                    while (++j < k && nums[j] == nums[j - 1]) {}
                }
                else if (threeSum > 0) k--;
                else if (threeSum < 0) j++;
            }
        }
        return out;
    }
}
