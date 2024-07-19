class Solution {
    /*
     * 각 단어의 문자를 a=0부터 j=9까지의 숫자로 해석한다.
     * 첫 두 단어의 값 합이 세 번째 단어의 값과 같은지 확인한다.
     */
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return value(firstWord) + value(secondWord) == value(targetWord);
    }

    private int value(String word) {
        int result = 0;

        for (char ch : word.toCharArray()) {
            result = result * 10 + ch - 'a';
        }

        return result;
    }
}
