class Solution {
    /*
     * 원본 배열 길이의 두 배인 새 배열을 만든다.
     * 같은 값을 앞 절반과 뒤 절반에 각각 복사한다.
     */
    public int[] getConcatenation(int[] nums) {
        int[] answer = new int[nums.length * 2];

        for (int i = 0; i < nums.length; i++) {
            answer[i] = nums[i];
            answer[i + nums.length] = nums[i];
        }

        return answer;
    }
}
