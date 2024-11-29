class Solution {
    /*
     * 인접한 같은 값을 만나면 앞 값을 두 배로 만들고 뒤 값을 0으로 만든다.
     * 이후 0이 아닌 값을 앞쪽으로 모아 결과 배열을 만든다.
     */
    public int[] applyOperations(int[] nums) {
        for (int i = 0; i + 1 < nums.length; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int[] answer = new int[nums.length];
        int index = 0;

        for (int number : nums) {
            if (number != 0) answer[index++] = number;
        }

        return answer;
    }
}
