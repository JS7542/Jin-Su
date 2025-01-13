import java.util.*;

class Solution {
    /*
     * nums[j]가 key인 모든 위치 주변의 k 범위를 boolean 배열에 표시한다.
     * 표시된 인덱스를 오름차순으로 결과 리스트에 추가한다.
     */
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        boolean[] marked = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != key) continue;

            int start = Math.max(0, i - k);
            int end = Math.min(nums.length - 1, i + k);

            for (int index = start; index <= end; index++) marked[index] = true;
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < marked.length; i++) {
            if (marked[i]) answer.add(i);
        }

        return answer;
    }
}
