class Solution {
    /*
     * 각 비트 위치에서 1이 등장한 횟수를 센다.
     * 횟수를 3으로 나눈 나머지가 1인 비트를 정답에 복원한다.
     */
    public int singleNumber(int[] nums) {
        int answer = 0;

        for (int bit = 0; bit < 32; bit++) {
            int count = 0;

            for (int number : nums) {
                count += (number >>> bit) & 1;
            }

            if (count % 3 != 0) answer |= 1 << bit;
        }

        return answer;
    }
}
