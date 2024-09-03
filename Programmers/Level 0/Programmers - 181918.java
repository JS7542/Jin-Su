import java.util.*;

class Solution {
    /*
     * 스택이 비었거나 마지막 값이 현재 값보다 작으면 현재 값을 추가한다.
     * 그렇지 않으면 스택의 마지막 값을 제거하고 같은 원소를 다시 비교한다.
     */
    public int[] solution(int[] arr) {
        List<Integer> stack = new ArrayList<>();
        int index = 0;

        while (index < arr.length) {
            if (stack.isEmpty() || stack.get(stack.size() - 1) < arr[index]) {
                stack.add(arr[index++]);
            } else {
                stack.remove(stack.size() - 1);
            }
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}
