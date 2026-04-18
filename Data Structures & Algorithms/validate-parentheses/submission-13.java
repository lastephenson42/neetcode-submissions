class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> parenMap = new HashMap<Character, Character>();
        parenMap.put('(', ')');
        parenMap.put('{', '}');
        parenMap.put('[', ']');

        Deque<Character> stack = new ArrayDeque<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // opening paren
            if (parenMap.containsKey(c)) {
                stack.offerFirst(parenMap.get(c));

            // closing paren
            } else if (stack.isEmpty() || stack.pollFirst() != c) {
                return false;
            }

        }
        return stack.isEmpty();
    }
}
