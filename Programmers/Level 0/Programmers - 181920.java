class Solution {
    /*
     * start_num부터 end_num까지의 정수 개수만큼 배열을 만든다.
     * 시작값에 인덱스를 더한 값을 각 위치에 저장한다.
     */
    public int[] solution(int start_num, int end_num) {
        int[] answer = new int[end_num - start_num + 1];

        for (int i = 0; i < answer.length; i++) answer[i] = start_num + i;
        return answer;
    }
}
