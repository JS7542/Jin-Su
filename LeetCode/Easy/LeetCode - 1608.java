class Solution {
    /*
     * 가능한 x를 0부터 배열 길이까지 모두 확인한다.
     * x 이상인 원소 개수가 정확히 x이면 해당 값을 반환한다.
     */
    public int specialArray(int[] nums) {
        for (int x = 0; x <= nums.length; x++) {
            int count = 0;
            for (int number : nums) if (number >= x) count++;
            if (count == x) return x;
        }

        return -1;
    }
}
