class Solution {

    public String encode(List<String> strs) {
        // no input strings
        if (strs.isEmpty()) {
            return "";
        }

        // factor in: one and many input strings, an empty string
        // <len>#<string>
        
        StringBuilder encodedString = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            // add string len, separate by #, add each string
            // decode- read string as one until you it a hashtag
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

        // decode string, scan int until #, read string, repeat
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
            // clear stringBuilder
        }

        return strs;
    }
}
