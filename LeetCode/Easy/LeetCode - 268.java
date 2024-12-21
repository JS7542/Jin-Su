class Solution {
    /*
     * 0부터 n까지의 모든 수와 배열 원소를 XOR한다.
     * 두 번 등장하는 값은 사라지고 배열에 없는 숫자만 남는다.
     */
    public int missingNumber(int[] nums) {
        int answer = nums.length;

        for (int i = 0; i < nums.length; i++) {
            answer ^= i;
            answer ^= nums[i];
        }

        return answer;
    }
}
