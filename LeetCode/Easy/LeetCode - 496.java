import java.util.*;

class Solution {
    /*
     * nums2를 단조 감소 스택으로 순회해 각 값의 다음 큰 수를 구한다.
     * 계산 결과를 해시맵에 저장하고 nums1의 순서대로 답 배열을 만든다.
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> next = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int number : nums2) {
            while (!stack.isEmpty() && stack.peek() < number) {
                next.put(stack.pop(), number);
            }
            stack.push(number);
        }

        int[] answer = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            answer[i] = next.getOrDefault(nums1[i], -1);
        }
        return answer;
    }
}
