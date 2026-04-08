import java.util.*;

class MinStack {
    private final Deque<Integer> values = new ArrayDeque<>();
    private final Deque<Integer> minimums = new ArrayDeque<>();

    /*
     * 일반 값 스택과 각 시점의 최솟값 스택을 함께 유지한다.
     * 값을 넣을 때 현재 최솟값을 저장하므로 pop·top·getMin을 모두 O(1)에 처리한다.
     */
    public MinStack() {
    }

    public void push(int val) {
        values.push(val);

        if (minimums.isEmpty()) minimums.push(val);
        else minimums.push(Math.min(val, minimums.peek()));
    }

    public void pop() {
        values.pop();
        minimums.pop();
    }

    public int top() {
        return values.peek();
    }

    public int getMin() {
        return minimums.peek();
    }
}
