class Solution {
    public boolean isAnagram(String s, String t) {        
        // use an arrayto track the frequencies of each letter

        // increment the frequency for a specific letter for s
        // decremment it for a specific letter for t

        // the words are anagrams if all frequencies are 0
        // meaning the increments and decrements canceled out
        
        // accounts for cases where different letters ascii value may add up to the same as 
        // others added together

        // 26 letters in alphabet
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
