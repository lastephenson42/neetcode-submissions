class Solution {
    public int[] topKFrequent(int[] nums, int k) {

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