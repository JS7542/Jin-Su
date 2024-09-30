class Solution {
    /*
     * start부터 end까지 감소하는 정수 개수만큼 배열을 만든다.
     * 각 위치에 start에서 인덱스를 뺀 값을 저장한다.
     */
    public int[] solution(int start, int end) {
        int[] answer = new int[start - end + 1];

        for (int i = 0; i < answer.length; i++) answer[i] = start - i;
        return answer;
    }
}
