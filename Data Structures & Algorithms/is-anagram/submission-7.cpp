class Solution {
   public:
    bool isAnagram(string s, string t) {
        int letters[26] = {0};
        int sLen = 0;
        int tLen = 0;

        // s: let[a] = 26, let[b] = 1
        // t: let[b] = 26, let[a] =

        for (int i = 0; s[i] != '\0'; i++) {
            letters[s[i] - 'a']++;
            sLen++;
        }

        for (int i = 0; t[i] != '\0'; i++) {
            letters[t[i] - 'a']--;
            tLen++;
        }

        if (sLen != tLen) {
            return false;
        }

        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) {
                return false;
            }
        }

        return true;
    }
};
