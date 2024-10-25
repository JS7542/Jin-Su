class Solution {
    /*
     * 1부터 두 수 중 작은 값까지 순회한다.
     * a와 b를 모두 나누어떨어지게 하는 수의 개수를 센다.
     */
    public int commonFactors(int a, int b) {
        int answer = 0;

        for (int factor = 1; factor <= Math.min(a, b); factor++) {
            if (a % factor == 0 && b % factor == 0) answer++;
        }

        return answer;
    }
}
