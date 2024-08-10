class Solution {
    /*
     * 각 원소가 1이 될 때까지 2로 나누는 연산을 반복한다.
     * 모든 원소에 수행한 연산 횟수를 합산해 반환한다.
     */
    public int solution(int[] num_list) {
        int answer = 0;

        for (int number : num_list) {
            while (number > 1) {
                number /= 2;
                answer++;
            }
        }

        return answer;
    }
}
