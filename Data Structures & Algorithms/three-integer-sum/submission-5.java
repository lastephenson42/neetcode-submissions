class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        Arrays.sort(nums);

        int i = 0;
        int j = i + 1;
        int k = nums.length - 1;
        int target = 0;
        int sum = 0;

        while (i <= nums.length - 3) {
            target = -nums[i];
            sum = nums[j] + nums[k];

            if (j >= k) {
                i++;
                while (i <= nums.length - 3 && nums[i] == nums[i - 1]) i++;
                j = i + 1;
                k = nums.length - 1;
                continue;
            } else if (sum == target) {
                out.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                j++;
                while (j < k && nums[j] == nums[j - 1]) j++;
                k--;
                while (k > j && nums[k] == nums[k + 1]) k--;
            } else if (sum > target) {
                k--;
            } else if (sum < target) {
                j++;
            }
        }
        return out;
    }
}