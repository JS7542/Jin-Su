class Solution {
    /*
     * 숫자 문자열의 오른쪽 끝에서 0이 아닌 문자를 찾는다.
     * 해당 위치까지의 접두사를 잘라 반환한다.
     */
    public String removeTrailingZeros(String num) {
        int end = num.length();

        while (end > 0 && num.charAt(end - 1) == '0') end--;

        return num.substring(0, end);
    }
}
