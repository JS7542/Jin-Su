class Solution {
    /*
     * 원본 문자열의 i번째 문자를 indices[i] 위치에 배치한다.
     * 모든 문자를 새 문자 배열에 넣고 문자열로 반환한다.
     */
    public String restoreString(String s, int[] indices) {
        char[] answer = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            answer[indices[i]] = s.charAt(i);
        }

        return new String(answer);
    }
}
