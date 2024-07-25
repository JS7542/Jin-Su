import java.util.*;

class Solution {
    /*
     * 결과 리스트의 마지막 값과 현재 값이 같으면 마지막 값을 제거한다.
     * 다르면 현재 값을 추가하고, 최종 리스트가 비면 -1 배열을 반환한다.
     */
    public int[] solution(int[] arr) {
        List<Integer> stack = new ArrayList<>();

        for (int number : arr) {
            if (!stack.isEmpty() && stack.get(stack.size() - 1) == number) {
                stack.remove(stack.size() - 1);
            } else {
                stack.add(number);
            }
        }

        return stack.isEmpty()
                ? new int[]{-1}
                : stack.stream().mapToInt(Integer::intValue).toArray();
    }
}
