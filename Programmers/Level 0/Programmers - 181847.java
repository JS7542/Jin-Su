class Solution {
    /*
     * 숫자 문자열을 정수로 변환하면 앞쪽의 불필요한 0이 제거된다.
     * 변환된 정수를 다시 문자열로 만들어 반환한다.
     */
    public String solution(String n_str) {
        return String.valueOf(Integer.parseInt(n_str));
    }
}
