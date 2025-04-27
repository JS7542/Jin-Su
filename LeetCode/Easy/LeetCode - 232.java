import java.util.*;

class MyQueue {
    /*
     * 입력 스택과 출력 스택을 분리한다.
     * 출력이 필요할 때만 입력 스택의 값을 뒤집어 옮겨 큐 순서를 만든다.
     */
    private final Deque<Integer> input = new ArrayDeque<>();
    private final Deque<Integer> output = new ArrayDeque<>();

    public MyQueue() {}

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        move();
        return output.pop();
    }

    public int peek() {
        move();
        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

    private void move() {
        if (!output.isEmpty()) return;

        while (!input.isEmpty()) output.push(input.pop());
    }
}
