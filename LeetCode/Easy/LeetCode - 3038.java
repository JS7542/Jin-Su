class Solution {
    /*
     * 첫 두 원소의 합을 목표 점수로 정한다.
     * 앞에서부터 두 개씩 묶어 합이 목표와 같은 동안 연산 횟수를 센다.
     */
    public int maxOperations(int[] nums) {
        int target = nums[0] + nums[1];
        int answer = 0;

        for (int i = 0; i + 1 < nums.length; i += 2) {
            if (nums[i] + nums[i + 1] != target) break;
            answer++;
        }

        return answer;
    }
}
