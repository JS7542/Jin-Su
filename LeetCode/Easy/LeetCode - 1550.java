class Solution {
    /*
     * 홀수를 만나면 연속 홀수 개수를 증가시키고 짝수를 만나면 초기화한다.
     * 연속 개수가 3이 되는 순간 true를 반환한다.
     */
    public boolean threeConsecutiveOdds(int[] arr) {
        int consecutive = 0;

        for (int number : arr) {
            consecutive = number % 2 == 1 ? consecutive + 1 : 0;
            if (consecutive == 3) return true;
        }

        return false;
    }
}
