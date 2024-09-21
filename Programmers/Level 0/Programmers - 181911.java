class Solution {
    /*
     * 각 문자열에서 parts가 지정한 시작부터 끝까지의 구간을 자른다.
     * 잘라낸 부분문자열을 순서대로 이어 붙여 반환한다.
     */
    public String solution(String[] my_strings, int[][] parts) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < my_strings.length; i++) {
            answer.append(my_strings[i], parts[i][0], parts[i][1] + 1);
        }

        return answer.toString();
    }
}
