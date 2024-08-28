class Solution {
    /*
     * k의 배수 중 n 이하인 값의 개수만큼 배열을 만든다.
     * k부터 시작해 k씩 증가하는 값을 차례대로 저장한다.
     */
    public int[] solution(int n, int k) {
        int[] answer = new int[n / k];

        for (int i = 0; i < answer.length; i++) answer[i] = k * (i + 1);
        return answer;
    }
}
