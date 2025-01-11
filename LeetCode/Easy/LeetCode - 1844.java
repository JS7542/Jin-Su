class Solution {
    /*
     * 홀수 인덱스의 숫자를 바로 앞 문자에서 이동할 거리로 사용한다.
     * 이동한 문자로 숫자 위치를 교체해 새 문자열을 만든다.
     */
    public String replaceDigits(String s) {
        char[] chars = s.toCharArray();

        for (int i = 1; i < chars.length; i += 2) {
            chars[i] = (char) (chars[i - 1] + chars[i] - '0');
        }

        return new String(chars);
    }
}
