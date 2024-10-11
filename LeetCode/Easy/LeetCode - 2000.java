class Solution {
    /*
     * word에서 ch가 처음 등장하는 인덱스를 찾는다.
     * 해당 위치까지의 접두사를 뒤집고 나머지 문자열을 이어 붙인다.
     */
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index == -1) return word;

        return new StringBuilder(word.substring(0, index + 1)).reverse()
                + word.substring(index + 1);
    }
}
