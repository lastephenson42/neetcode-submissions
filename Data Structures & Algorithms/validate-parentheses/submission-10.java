class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> parenMap = new HashMap<Character, Character>();
        parenMap.put('(', ')');
        parenMap.put('{', '}');
        parenMap.put('[', ']');

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // opening paren
            if (parenMap.containsKey(c)) {
                stack.push(parenMap.get(c));

            // closing paren
            } else if (parenMap.containsValue(c)) {
                if (stack.isEmpty()) {
                    return false;
                }

                if (!(stack.pop().equals(c))) {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
}
