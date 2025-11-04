import java.util.*;

class Solution {
    /*
     * 더 따뜻한 날을 찾지 못한 인덱스를 단조 감소 스택에 저장한다.
     * 현재 온도가 더 높으면 스택 인덱스와의 날짜 차이를 정답에 기록한다.
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int day = 0; day < temperatures.length; day++) {
            while (!stack.isEmpty()
                    && temperatures[stack.peek()] < temperatures[day]) {
                int previous = stack.pop();
                answer[previous] = day - previous;
            }

            stack.push(day);
        }

        return answer;
    }
}
