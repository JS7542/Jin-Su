class Solution {
    /*
     * 문자열에서 l보다 사전순으로 앞선 문자를 찾는다.
     * 해당 문자를 모두 l로 바꾸고 나머지는 그대로 유지한다.
     */
    public String solution(String myString) {
        char[] chars = myString.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < 'l') chars[i] = 'l';
        }

        return new String(chars);
    }
}
