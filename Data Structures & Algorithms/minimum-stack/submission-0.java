
class MinStack {
    private record Pair<A, B>(A min, B val) {}
    private Deque<Pair<Integer, Integer>> stack;

    public MinStack() {
        stack = new ArrayDeque<Pair<Integer, Integer>>();
    }

    public void push(int val) {
        Pair<Integer, Integer> elem;

        if (stack.isEmpty()) {
            elem = new Pair(val, val);
        } else {
            int min = stack.peekFirst().min;
            min = (min < val) ? min : val;
            elem = new Pair(min, val);
        }

        stack.offerFirst(elem);
    }

    // always called on non-empty stacks
    public void pop() {
        stack.remove();
    }

    // always called on non-empty stacks
    public int top() {
        return stack.peekFirst().val;
    }

    // always called on non-empty stacks
    public int getMin() {
        return stack.peekFirst().min;
    }
}
