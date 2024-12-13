class Solution {
    /*
     * n을 k로 반복해서 나눈 나머지가 k진법의 각 자리수다.
     * 모든 나머지를 합산해 자리수 합을 반환한다.
     */
    public int sumBase(int n, int k) {
        int answer = 0;

        while (n > 0) {
            answer += n % k;
            n /= k;
        }

        return answer;
    }
}
