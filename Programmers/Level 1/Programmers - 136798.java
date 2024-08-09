class Solution {
    /*
     * 각 기사 번호의 약수 개수를 제곱근까지의 약수 쌍으로 계산한다.
     * 제한수보다 크면 지정 공격력을, 아니면 약수 개수를 무기 공격력에 더한다.
     */
    public int solution(int number, int limit, int power) {
        int answer = 0;

        for (int knight = 1; knight <= number; knight++) {
            int divisors = 0;

            for (int divisor = 1; divisor * divisor <= knight; divisor++) {
                if (knight % divisor == 0) {
                    divisors += divisor * divisor == knight ? 1 : 2;
                }
            }

            answer += divisors > limit ? power : divisors;
        }

        return answer;
    }
}
