class Solution {
    /*
     * 문장에 등장한 소문자를 boolean 배열에 표시한다.
     * 26개 알파벳이 모두 한 번 이상 등장했는지 확인한다.
     */
    public boolean checkIfPangram(String sentence) {
        boolean[] seen = new boolean[26];

        for (char ch : sentence.toCharArray()) seen[ch - 'a'] = true;
        for (boolean value : seen) if (!value) return false;

        return true;
    }
}
