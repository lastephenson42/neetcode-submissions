class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // while true: because solution is guaranteed 
        int i = 0;
        int j = numbers.length - 1;
        
        while (true) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                int[] idxs = {i + 1, j + 1};
                return idxs;
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
    }
}
