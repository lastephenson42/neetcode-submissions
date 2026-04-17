class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /////////////////////////////////////
        // One Issue - FREQUENCIES ARE NOT UNIQUE
        // so using frequency as key means when using put()
        // to add more entires, i may overwrite ones that have the same frequency

        ////////////////////////////////////
        //Methodoloy --
        //use hashmap to add entries (number in nums array, frequency of the number)
        //add hashmap entries sorted by frequency descending to a list
        //get the first k entries from that list, which will get
        //the most to least frequent

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                int freq = map.get(num);
                map.put(num, freq + 1);
            } else {
                map.put(num, 1);
            }
        }

        ArrayList<Integer> m = new ArrayList<>();

        map.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .forEach(kNew -> m.add(kNew.getKey()));

        int[] result = new int[k];

        for (int i = 0; i < k; i++){
            result[i] = m.get(i);
        }
        return result;

    }
}