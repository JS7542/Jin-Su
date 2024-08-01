class Solution {
    /*
     * 단어 배열의 각 문자열이 pref로 시작하는지 확인한다.
     * 조건을 만족하는 단어의 개수를 센다.
     */
    public int prefixCount(String[] words, String pref) {
        int answer = 0;

        for (String word : words) {
            if (word.startsWith(pref)) answer++;
        }

        return answer;
    }
}
