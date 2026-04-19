class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }

        int i = 0;
        int j = s.length() - 1;

        // ?
        // W
        // ?W?W

        while (i < j) {
            while (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                if (i >= j) {
                    return true;
                }
            }

            while (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                if (j <= i) {
                    return true;
                }
            }

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
