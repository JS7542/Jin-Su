class Solution {
    /*
     * 시와 분의 각 ?를 가능한 가장 큰 숫자로 바꾼다.
     * 24시간 형식의 범위를 넘지 않도록 앞뒤 자리 조건을 함께 확인한다.
     */
    public String maximumTime(String time) {
        char[] chars = time.toCharArray();

        if (chars[0] == '?') chars[0] = chars[1] == '?' || chars[1] <= '3' ? '2' : '1';
        if (chars[1] == '?') chars[1] = chars[0] == '2' ? '3' : '9';
        if (chars[3] == '?') chars[3] = '5';
        if (chars[4] == '?') chars[4] = '9';

        return new String(chars);
    }
}
