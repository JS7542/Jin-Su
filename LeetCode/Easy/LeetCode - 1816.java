class Solution {
    /*
     * 문장을 공백 기준 단어 배열로 나눈다.
     * 처음 k개 단어만 공백으로 다시 이어 붙여 반환한다.
     */
    public String truncateSentence(String s, int k) {
        String[] words = s.split(" ");
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < k; i++) {
            if (i > 0) answer.append(' ');
            answer.append(words[i]);
        }

        return answer.toString();
    }
}
