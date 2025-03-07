class Solution {
    /*
     * ? 위치마다 왼쪽 문자와 오른쪽 문자 모두와 다른 소문자를 선택한다.
     * a부터 c까지만 확인해도 항상 가능한 문자를 찾을 수 있다.
     */
    public String modifyString(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '?') continue;

            for (char candidate = 'a'; candidate <= 'c'; candidate++) {
                boolean leftValid = i == 0 || chars[i - 1] != candidate;
                boolean rightValid = i == chars.length - 1 || chars[i + 1] != candidate;

                if (leftValid && rightValid) {
                    chars[i] = candidate;
                    break;
                }
            }
        }

        return new String(chars);
    }
}
