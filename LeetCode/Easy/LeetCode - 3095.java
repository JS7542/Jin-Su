class Solution {
    /*
     * 각 시작 위치에서 끝 위치를 늘리며 비트 OR 값을 누적한다.
     * OR 값이 k 이상이 되는 첫 길이로 최솟값을 갱신한다.
     */
    public int minimumSubarrayLength(int[] nums, int k) {
        int answer = Integer.MAX_VALUE;

        for (int start = 0; start < nums.length; start++) {
            int or = 0;

            for (int end = start; end < nums.length; end++) {
                or |= nums[end];

                if (or >= k) {
                    answer = Math.min(answer, end - start + 1);
                    break;
                }
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
