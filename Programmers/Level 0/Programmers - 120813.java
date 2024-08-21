class Solution {
    /*
     * 1부터 n까지 존재하는 홀수의 개수만큼 배열을 만든다.
     * 1부터 2씩 증가시키며 홀수를 차례대로 저장한다.
     */
    public int[] solution(int n) {
        int[] answer = new int[(n + 1) / 2];
        for (int i = 0; i < answer.length; i++) answer[i] = i * 2 + 1;
        return answer;
    }
}
