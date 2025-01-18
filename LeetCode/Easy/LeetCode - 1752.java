class Solution {
    /*
     * 원형 배열에서 현재 값이 다음 값보다 큰 경계의 개수를 센다.
     * 정렬 배열을 회전한 결과라면 이러한 감소 경계는 최대 한 번만 나타난다.
     */
    public boolean check(int[] nums) {
        int drops = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[(i + 1) % nums.length]) drops++;
        }

        return drops <= 1;
    }
}
