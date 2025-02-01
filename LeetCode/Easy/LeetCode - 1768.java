class Solution {
    /*
     * 두 문자열의 같은 인덱스 문자를 번갈아 결과에 추가한다.
     * 한 문자열이 먼저 끝나면 남은 문자열의 문자를 계속 추가한다.
     */
    public String mergeAlternately(String word1, String word2) {
        StringBuilder answer = new StringBuilder();
        int length = Math.max(word1.length(), word2.length());

        for (int i = 0; i < length; i++) {
            if (i < word1.length()) answer.append(word1.charAt(i));
            if (i < word2.length()) answer.append(word2.charAt(i));
        }

        return answer.toString();
    }
}
