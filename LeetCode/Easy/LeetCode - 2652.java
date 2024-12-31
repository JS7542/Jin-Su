class Solution {
    /*
     * 1부터 n까지 3, 5, 7 중 하나의 배수인지 확인한다.
     * 조건을 만족하는 수를 모두 합산한다.
     */
    public int sumOfMultiples(int n) {
        int answer = 0;

        for (int value = 1; value <= n; value++) {
            if (value % 3 == 0 || value % 5 == 0 || value % 7 == 0) answer += value;
        }

        return answer;
    }
}
