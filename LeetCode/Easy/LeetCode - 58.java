class Solution {
    /*
     * 문자열 끝의 공백을 건너뛴 뒤 마지막 단어의 문자를 거꾸로 센다.
     * 공백이나 문자열 시작을 만날 때까지 센 길이를 반환한다.
     */
    public int lengthOfLastWord(String s) {
        int index = s.length() - 1;
        while (index >= 0 && s.charAt(index) == ' ') index--;

        int length = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            length++;
            index--;
        }

        return length;
    }
}
