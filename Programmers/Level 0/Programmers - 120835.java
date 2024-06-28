class Solution {
    /*
     * 각 환자의 응급도보다 큰 값의 개수를 세면 해당 환자의 순위가 된다.
     * 큰 값 개수에 1을 더해 모든 환자의 진료 순서를 구한다.
     */
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];

        for (int i = 0; i < emergency.length; i++) {
            answer[i] = 1;
            for (int value : emergency) {
                if (value > emergency[i]) answer[i]++;
            }
        }

        return answer;
    }
}
