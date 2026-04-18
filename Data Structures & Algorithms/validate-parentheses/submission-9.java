class Solution {
    public boolean isValid(String s) {
        String[] openArr = {"(", "{", "["};
        String[] closedArr = {")", "}", "]"};
        String[] stringList = s.split("");

        List<String> openList = new ArrayList<String>(Arrays.asList(openArr));
        List<String> closedList = new ArrayList<String>(Arrays.asList(closedArr));
        Stack<String> parenQ = new Stack<String>();

        for (String c : stringList) {
            if (openList.contains(c)) {
                parenQ.push(c);

            } else if (closedList.contains(c)) {
                if (parenQ.isEmpty()) {
                    return false;
                }

                int closedIdx = closedList.indexOf(c);
                if (openList.get(closedIdx).equals(parenQ.peek())) {
                    parenQ.pop();
                } else {
                    return false;
                }
            }
        }
        return parenQ.isEmpty();
    }
}
