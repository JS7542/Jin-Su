class Solution {
    /*
     * 배열의 앞 절반과 뒤 절반에서 같은 인덱스 값을 번갈아 꺼낸다.
     * x1, y1, x2, y2 순서가 되도록 새 배열에 저장한다.
     */
    public int[] shuffle(int[] nums, int n) {
        int[] answer = new int[nums.length];

        for (int i = 0; i < n; i++) {
            answer[i * 2] = nums[i];
            answer[i * 2 + 1] = nums[i + n];
        }

        return answer;
    }
}
