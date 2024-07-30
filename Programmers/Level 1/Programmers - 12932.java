class Solution {
    /*
     * 숫자를 문자열로 바꾸고 끝 문자부터 순회한다.
     * 각 문자를 정수로 변환해 뒤집힌 순서의 배열에 저장한다.
     */
    public int[] solution(long n) {
        String text = String.valueOf(n);
        int[] answer = new int[text.length()];

        for (int i = 0; i < text.length(); i++) {
            answer[i] = text.charAt(text.length() - 1 - i) - '0';
        }

        return answer;
    }
}
