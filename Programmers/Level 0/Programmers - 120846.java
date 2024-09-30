class Solution {
    /*
     * 4부터 n까지 각 수의 약수 개수를 센다.
     * 1과 자기 자신 외의 약수가 존재하면 합성수로 카운트한다.
     */
    public int solution(int n) {
        int answer = 0;

        for (int value = 4; value <= n; value++) {
            for (int divisor = 2; divisor * divisor <= value; divisor++) {
                if (value % divisor == 0) {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}
