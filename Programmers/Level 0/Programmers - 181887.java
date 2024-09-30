class Solution {
    /*
     * 1부터 시작하는 홀수 번째 위치와 짝수 번째 위치의 원소 합을 따로 구한다.
     * 두 합 중 더 큰 값을 반환한다.
     */
    public int solution(int[] num_list) {
        int oddPosition = 0;
        int evenPosition = 0;

        for (int i = 0; i < num_list.length; i++) {
            if (i % 2 == 0) oddPosition += num_list[i];
            else evenPosition += num_list[i];
        }

        return Math.max(oddPosition, evenPosition);
    }
}
