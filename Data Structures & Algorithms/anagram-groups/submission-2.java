class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // make a map with entries (sorted word, list of words)
        // key is the word sorted

        // to add entries to the map
        // sort the word, search for sorted word as a key
        // if the key exists, add it to the list
        // otherwise make a new list

        HashMap<String,List<String>> map = new HashMap<>();

        for (String word : strs) {
            // convert to char array
            char[] wordChar = word.toCharArray();
            Arrays.sort(wordChar);
            String sortedWord = new String(wordChar);

            // if no matching key is found
            if (!map.containsKey(sortedWord)) {
                // create new empty list entry
                ArrayList<String> list = new ArrayList<>();
                map.put(sortedWord, list);
            }

            // add word to the map entry
            map.get(sortedWord).add(word);
        }

        // return a List of each list in map
        // use the values() method for this
        return new ArrayList<>(map.values());
    }
}