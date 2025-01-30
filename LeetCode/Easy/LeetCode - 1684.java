class Solution {
    /*
     * 허용된 문자를 boolean 배열에 표시한다.
     * 각 단어의 모든 문자가 허용 목록에 포함되는 경우만 센다.
     */
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] valid = new boolean[26];
        for (char ch : allowed.toCharArray()) valid[ch - 'a'] = true;

        int answer = 0;

        for (String word : words) {
            boolean consistent = true;

            for (char ch : word.toCharArray()) {
                if (!valid[ch - 'a']) {
                    consistent = false;
                    break;
                }
            }

            if (consistent) answer++;
        }

        return answer;
    }
}
