class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // frequency map

        // if number is not in map
        // add an entry with (number, frequency of number)

        // if number is in map, get the entry and add one to the frequency

        // make a new skiplist map and insert old map entries as such (frequency,
        // number)

        /////////////////////////////////////
        // CURRENT ISSUE - FREQUENCIES ARE NOT UNIQUE
        // so using frequency as key means when using put()
        // to add more entires, i may overwrite ones that have the same frequency

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