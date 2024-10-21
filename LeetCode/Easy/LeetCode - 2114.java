class Solution {
    /*
     * 문장의 단어 수는 공백 개수에 1을 더한 값이다.
     * 모든 문장의 단어 수 중 최댓값을 반환한다.
     */
    public int mostWordsFound(String[] sentences) {
        int answer = 0;

        for (String sentence : sentences) {
            answer = Math.max(answer, sentence.split(" ").length);
        }

        return answer;
    }
}
