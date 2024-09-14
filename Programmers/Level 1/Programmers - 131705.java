class Solution {
    /*
     * 서로 다른 학생 세 명을 고르는 모든 조합을 확인한다.
     * 세 정수의 합이 0인 조합의 개수를 센다.
     */
    public int solution(int[] number) {
        int answer = 0;

        for (int i = 0; i < number.length - 2; i++) {
            for (int j = i + 1; j < number.length - 1; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    if (number[i] + number[j] + number[k] == 0) answer++;
                }
            }
        }

        return answer;
    }
}
