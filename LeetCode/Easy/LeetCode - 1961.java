class Solution {
    /*
     * words를 앞에서부터 이어 붙이며 s와 길이 및 내용이 맞는지 확인한다.
     * 이어 붙인 문자열이 정확히 s와 같아지는 순간 true를 반환한다.
     */
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder prefix = new StringBuilder();

        for (String word : words) {
            prefix.append(word);

            if (prefix.length() == s.length()) return prefix.toString().equals(s);
            if (prefix.length() > s.length()) return false;
        }

        return false;
    }
}
