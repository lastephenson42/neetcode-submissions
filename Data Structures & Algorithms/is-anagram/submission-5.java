class Solution {
    public boolean isAnagram(String s, String t) {        
        // sort both strings
        // if anagrams, they contain the same characters
        // thus, sorted, they will be arranged the same

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        String sSorted = new String(sArr);
        String tSorted = new String(tArr);

        return sSorted.equals(tSorted);
    }
}
