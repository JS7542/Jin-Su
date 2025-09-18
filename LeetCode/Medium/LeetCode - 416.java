class Solution {
    /*
     * 전체 합이 홀수이면 두 부분집합의 합을 같게 만들 수 없다.
     * 목표 합까지 가능한 부분집합 합을 0/1 배낭 방식으로 뒤에서부터 갱신한다.
     */
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int number : nums) total += number;

        if (total % 2 == 1) return false;

        int target = total / 2;
        boolean[] possible = new boolean[target + 1];
        possible[0] = true;

        for (int number : nums) {
            for (int sum = target; sum >= number; sum--) {
                possible[sum] |= possible[sum - number];
            }
        }

        return possible[target];
    }
}
