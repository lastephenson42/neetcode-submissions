class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }

        int longestCount = 0;
        for (int num : numsSet) {
            // if num is not the start of sequence ignore it
            if (numsSet.contains(num - 1)) {
                continue;
            }

            // count consecutive nums
            int count = 0;
            int nextNum = num;
            while (numsSet.contains(nextNum)) {
                count++;
                nextNum++;
            }

            longestCount = (longestCount > count) ? longestCount : count;
        }

        return longestCount;
    }
}