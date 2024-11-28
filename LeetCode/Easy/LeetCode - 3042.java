class Solution {
    /*
     * 모든 i<j 단어 쌍을 확인한다.
     * words[i]가 words[j]의 접두사이면서 접미사인 경우를 센다.
     */
    public int countPrefixSuffixPairs(String[] words) {
        int answer = 0;

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].startsWith(words[i]) && words[j].endsWith(words[i])) answer++;
            }
        }

        return answer;
    }
}
