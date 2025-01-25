class Solution {
    /*
     * answer[i]는 nums의 nums[i] 인덱스에 있는 값이다.
     * 각 위치의 값을 직접 조회해 새 배열에 저장한다.
     */
    public int[] buildArray(int[] nums) {
        int[] answer = new int[nums.length];

        for (int i = 0; i < nums.length; i++) answer[i] = nums[nums[i]];
        return answer;
    }
}
