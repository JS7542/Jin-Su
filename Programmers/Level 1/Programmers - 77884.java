class Solution {
    /*
     * 완전제곱수만 약수 개수가 홀수라는 성질을 사용한다.
     * 제곱수는 빼고 나머지 수는 더해 구간 결과를 계산한다.
     */
    public int solution(int left, int right) {
        int answer = 0;

        for (int value = left; value <= right; value++) {
            int root = (int) Math.sqrt(value);
            answer += root * root == value ? -value : value;
        }

        return answer;
    }
}
