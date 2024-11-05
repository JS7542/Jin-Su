class Solution {
    /*
     * 문자열을 복제하면서 각 문자를 다음 알파벳으로 바꾼 문자열을 뒤에 붙인다.
     * 길이가 k 이상이 될 때까지 반복한 뒤 k번째 문자를 반환한다.
     */
    public char kthCharacter(int k) {
        StringBuilder word = new StringBuilder("a");

        while (word.length() < k) {
            int length = word.length();

            for (int i = 0; i < length; i++) {
                word.append((char) (word.charAt(i) + 1));
            }
        }

        return word.charAt(k - 1);
    }
}
