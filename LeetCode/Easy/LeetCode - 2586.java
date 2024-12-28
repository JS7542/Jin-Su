class Solution {
    /*
     * left부터 right까지의 단어만 확인한다.
     * 첫 문자와 마지막 문자가 모두 모음인 단어의 개수를 센다.
     */
    public int vowelStrings(String[] words, int left, int right) {
        String vowels = "aeiou";
        int answer = 0;

        for (int i = left; i <= right; i++) {
            String word = words[i];

            if (vowels.indexOf(word.charAt(0)) >= 0
                    && vowels.indexOf(word.charAt(word.length() - 1)) >= 0) {
                answer++;
            }
        }

        return answer;
    }
}
