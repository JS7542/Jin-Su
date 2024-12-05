class Solution {
    /*
     * 문장을 공백 기준 단어로 나눈다.
     * searchWord로 시작하는 첫 단어의 1부터 시작하는 위치를 반환한다.
     */
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWord)) return i + 1;
        }

        return -1;
    }
}
