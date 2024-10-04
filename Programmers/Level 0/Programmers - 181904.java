class Solution {
    /*
     * 문자열을 길이 m의 행으로 나누었다고 생각한다.
     * 각 행의 c번째 문자인 인덱스 c-1부터 m칸 간격으로 선택한다.
     */
    public String solution(String my_string, int m, int c) {
        StringBuilder answer = new StringBuilder();

        for (int i = c - 1; i < my_string.length(); i += m) {
            answer.append(my_string.charAt(i));
        }

        return answer.toString();
    }
}
