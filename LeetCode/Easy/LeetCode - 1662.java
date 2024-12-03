class Solution {
    /*
     * 각 문자열 배열의 원소를 모두 이어 붙인다.
     * 완성된 두 문자열이 같은지 비교한다.
     */
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return String.join("", word1).equals(String.join("", word2));
    }
}
