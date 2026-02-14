class Solution {
    /*
     * 배열 값을 다음 인덱스로 보는 연결 리스트로 해석한다.
     * 플로이드 순환 탐지로 만나는 지점을 찾고 시작점과 함께 이동해 순환 진입값을 구한다.
     */
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
