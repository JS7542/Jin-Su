import java.util.*;

class Solution {
    /*
     * 가격이 떨어지지 않은 인덱스를 스택에 저장한다.
     * 현재 가격이 더 낮으면 스택에서 꺼낸 인덱스의 유지 시간을 계산한다.
     */
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int index = stack.pop();
                answer[index] = i - index;
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = prices.length - 1 - index;
        }

        return answer;
    }
}
