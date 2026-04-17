class Solution {
    public int[] twoSum(int[] nums, int target) {
        // optimization brainstorming ------------------->

        ///////////////////
        // make map for the entries in nums
        // for loop to add each number in nums to a map with entries {number, index}
        /////////////////// nlogn?

        // do target - current num to find the number we need for twoSum
        // do get in map to check if the number exists

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] intArr = new int[2];

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int targetNum = target - nums[i];
            Integer index = map.get(targetNum);

            if (index != null) {
                if (index != i) {
                    intArr[0] = i;
                    intArr[1] = index;
                    break;
                }
            }
        }

        return intArr;
    }
}