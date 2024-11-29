class Solution {
    /*
     * words의 각 문자열이 s의 시작 부분과 같은지 확인한다.
     * s의 접두사인 단어의 개수를 센다.
     */
    public int countPrefixes(String[] words, String s) {
        int answer = 0;

        for (String word : words) {
            if (s.startsWith(word)) answer++;
        }

        return answer;
    }
}
