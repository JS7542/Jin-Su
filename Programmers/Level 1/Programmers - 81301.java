class Solution {
    /*
     * zero부터 nine까지의 영단어를 대응하는 숫자 문자로 치환한다.
     * 변환이 끝난 숫자 문자열을 정수로 반환한다.
     */
    public int solution(String s) {
        String[] words = {
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine"
        };

        for (int number = 0; number <= 9; number++) {
            s = s.replace(words[number], String.valueOf(number));
        }

        return Integer.parseInt(s);
    }
}
