class Solution {
    /*
     * 이동량을 순서대로 누적해 개미의 현재 위치를 계산한다.
     * 이동 후 위치가 0이 되는 횟수를 센다.
     */
    public int returnToBoundaryCount(int[] nums) {
        int position = 0;
        int answer = 0;

        for (int move : nums) {
            position += move;
            if (position == 0) answer++;
        }

        return answer;
    }
}
