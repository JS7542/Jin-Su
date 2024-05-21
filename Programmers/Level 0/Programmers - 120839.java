class Solution {
    /*
     * 입력 문자 2, 0, 5에 각각 이기는 수 0, 5, 2를 대응시킨다.
     * 모든 문자를 변환해 이기는 경우의 문자열을 만든다.
     */
    public String solution(String rsp) {
        StringBuilder sb = new StringBuilder();
        for (char ch : rsp.toCharArray()) {
            if (ch == '2') sb.append('0');
            else if (ch == '0') sb.append('5');
            else sb.append('2');
        }
        return sb.toString();
    }
}
