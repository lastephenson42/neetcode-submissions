class Solution {

    // accounts for:
    // an empty input array
    // one string in the array
    // many strings in the array
    // an empty string in the array
    public String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return "";
        }

        // encode as: <string_length>#<string_literal>
        StringBuilder encodedString = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            // add string len, separate by #, add string
            String curString = strs.get(i);
            encodedString.append(curString.length());
            encodedString.append("#");
            encodedString.append(curString);
        }

        return encodedString.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<String>();

        if (str.length() == 0) {
            return strs;
        }

        // decode string, scan len until #, read string using len, repeat
        int idx = 0;
        while(idx < str.length()) {
            StringBuilder strBuilder = new StringBuilder();
            char curChar = str.charAt(idx);

            // get strLen
            while(curChar != '#') {
                strBuilder.append(str.charAt(idx));
                idx++;
                curChar = str.charAt(idx);
            }
            idx++; // advance past #

            // read strLen chars to get the next String
            // ends with idx at the next #
            int len = Integer.parseInt(strBuilder.toString());
            int strEnd = idx + len;
            strBuilder.delete(0, strBuilder.length());
            for (idx = idx; idx < strEnd; idx++) {
                curChar = str.charAt(idx);
                strBuilder.append(curChar);
            }

            strs.add(strBuilder.toString());
            strBuilder.delete(0, strBuilder.length());
        }

        return strs;
    }
}
