class Solution {
    /*
     * 문자열의 오른쪽 끝부터 홀수 숫자를 찾는다.
     * 처음 발견한 홀수 자리까지의 접두사가 만들 수 있는 가장 큰 홀수다.
     */
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if ((num.charAt(i) - '0') % 2 == 1) return num.substring(0, i + 1);
        }

        return "";
    }
}
