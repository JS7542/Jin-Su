class Solution {
    /*
     * 문자열이 숫자로만 이루어졌으면 정수값을 사용한다.
     * 문자가 포함되면 문자열 길이를 값으로 사용해 최댓값을 구한다.
     */
    public int maximumValue(String[] strs) {
        int answer = 0;

        for (String text : strs) {
            int value;

            try {
                value = Integer.parseInt(text);
            } catch (NumberFormatException exception) {
                value = text.length();
            }

            answer = Math.max(answer, value);
        }

        return answer;
    }
}
