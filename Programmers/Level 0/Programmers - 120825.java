class Solution {
    /*
     * 문자열의 각 문자를 n번씩 반복해 StringBuilder에 추가한다.
     * 완성된 반복 문자열을 반환한다.
     */
    public String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();
        for (char ch : my_string.toCharArray()) {
            for (int i = 0; i < n; i++) sb.append(ch);
        }
        return sb.toString();
    }
}
