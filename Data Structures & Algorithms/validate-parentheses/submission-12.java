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
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }

        }
        return stack.isEmpty();
    }
}
