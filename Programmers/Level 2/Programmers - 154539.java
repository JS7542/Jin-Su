import java.util.*;

class Solution {
    /*
     * 아직 뒤의 큰 수를 찾지 못한 인덱스를 단조 감소 스택에 저장한다.
     * 현재 값이 더 크면 스택 인덱스의 정답을 현재 값으로 채운다.
     */
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int index = 0; index < numbers.length; index++) {
            while (!stack.isEmpty()
                    && numbers[stack.peek()] < numbers[index]) {
                answer[stack.pop()] = numbers[index];
            }

            stack.push(index);
        }

        return answer;
    }
}
