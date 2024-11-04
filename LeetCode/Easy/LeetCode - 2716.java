class Solution {
    /*
     * 삭제 연산 후 각 서로 다른 문자는 하나씩만 남길 수 있다.
     * 문자열에 등장하는 서로 다른 문자 개수를 반환한다.
     */
    public int minimizedStringLength(String s) {
        boolean[] seen = new boolean[26];
        int answer = 0;

        for (char ch : s.toCharArray()) {
            if (!seen[ch - 'a']) {
                seen[ch - 'a'] = true;
                answer++;
            }
        }

        return answer;
    }
}
