class Solution {
    /*
     * i보다 큰 j를 선택하는 모든 인덱스 쌍을 확인한다.
     * 두 값이 같고 인덱스 곱이 k로 나누어떨어지는 쌍을 센다.
     */
    public int countPairs(int[] nums, int k) {
        int answer = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && i * j % k == 0) answer++;
            }
        }

        return answer;
    }
}
