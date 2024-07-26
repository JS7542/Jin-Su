class Solution {
    /*
     * 2부터 시작해 n을 나눈 나머지가 1인지 확인한다.
     * 조건을 처음 만족한 가장 작은 자연수를 반환한다.
     */
    public int solution(int n) {
        for (int x = 2; x < n; x++) {
            if (n % x == 1) return x;
        }
        return n - 1;
    }
}
