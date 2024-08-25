class Solution {
    /*
     * 모든 숫자 쌍을 확인한다.
     * 두 값의 차이가 작은 값 이하인 강한 쌍의 XOR 최댓값을 구한다.
     */
    public int maximumStrongPairXor(int[] nums) {
        int answer = 0;

        for (int first : nums) {
            for (int second : nums) {
                if (Math.abs(first - second) <= Math.min(first, second)) {
                    answer = Math.max(answer, first ^ second);
                }
            }
        }

        return answer;
    }
}
