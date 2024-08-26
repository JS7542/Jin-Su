class Solution {
    /*
     * 배열을 순회하며 제거 대상 val이 아닌 값만 앞쪽에 덮어쓴다.
     * 저장된 원소 수를 새 배열 길이로 반환한다.
     */
    public int removeElement(int[] nums, int val) {
        int write = 0;
        for (int number : nums) {
            if (number != val) nums[write++] = number;
        }
        return write;
    }
}
