class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // create List<List<String>> to hold the final list
        // check isAnagram between a value in strs, and get(0) with a List in the created one
        // if not anagram, and there are no more lists to check, add it as its own group

        List<List<String>> group = new ArrayList<List<String>>();

        // create the initial group
        List<String> initList = new ArrayList<>();
        initList.add(strs[0]);
        group.add(initList);

        // for words in strs, ignore 0th index ^
        for (int i = 1; i < strs.length; i++) {
            // for groups of anagrams, comparing only first word
            boolean hadAnagram = false;
            for (int a = 0; a < group.size(); a++) {
                // check length between word in strs, and first word in grouped anagrams
                if (strs[i].length() == group.get(a).get(0).length()) {
                    // check if isAnagram
                    if (isAnagram(strs[i], group.get(a).get(0))) {
                        group.get(a).add(strs[i]);
                        hadAnagram = true;
                    }
                }
            }
            if (hadAnagram == false) {
                List<String> tempList = new ArrayList<>();
                tempList.add(strs[i]);
                group.add(tempList);
            }
        }

        return group;
    }

    /**
     * Returns if two given strings are anagrams. O(n)
     */
    private boolean isAnagram(String s, String t) {
        int[] freq = new int[26];

        // check length of strings
        if (s.length() != t.length()) {
            return false;
        }

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            freq[sChar[i] - 'a']++;
            freq[tChar[i] - 'a']--;
        }

        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}