class Solution {
    private HashMap<String, String> digitToLetters = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<String>();
        }

        digitToLetters.put("2", "abc");
        digitToLetters.put("3", "def");
        digitToLetters.put("4", "ghi");
        digitToLetters.put("5", "jkl");
        digitToLetters.put("6", "mno");
        digitToLetters.put("7", "pqrs");
        digitToLetters.put("8", "tuv");
        digitToLetters.put("9", "wxyz");

        return helper(digits);
    }

    private List<String> helper(String digits) {
        List<String> arr = new ArrayList<>();
        // digits should never be empty
        String possibleLetters = digitToLetters.get(digits.substring(0,1));

        // base case: last digit in the number
        // simply add each possible letter as its own entry in the array
        if (digits.length() == 1) {
            for (int i = 0; i < possibleLetters.length(); i++) {
                arr.add(possibleLetters.substring(i, i+1));
            }
            return arr;
        }

        // recursive case: more digits remain
        // take the digits returned from the helper
        // attach each letter (from the current digit) to each entry in returned helper array
        arr = helper(digits.substring(1, digits.length()));
        List<String> updatedArr = new ArrayList<>();

        for (int i = 0; i < possibleLetters.length(); i++) {
            String currentLetter = possibleLetters.substring(i, i+1);
            for (String combinations : arr) {
                updatedArr.add(currentLetter + combinations);
            }
        }

        return updatedArr;
    }
}