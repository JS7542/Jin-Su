class Solution {
    /*
     * 알파벳 빈도수를 저장한 뒤 작은 문자부터 큰 문자, 다시 큰 문자부터 작은 문자 순으로 꺼낸다.
     * 모든 빈도가 0이 될 때까지 왕복하며 결과 문자열을 만든다.
     */
    public String sortString(String s) {
        int[] count = new int[26];
        for (char ch : s.toCharArray()) count[ch - 'a']++;

        StringBuilder answer = new StringBuilder();

        while (answer.length() < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    answer.append((char) ('a' + i));
                    count[i]--;
                }
            }

            for (int i = 25; i >= 0; i--) {
                if (count[i] > 0) {
                    answer.append((char) ('a' + i));
                    count[i]--;
                }
            }
        }

        return answer.toString();
    }
}
