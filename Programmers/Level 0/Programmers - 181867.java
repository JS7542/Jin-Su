class Solution {
    /*
     * 문자열을 x 기준으로 나누되 끝의 빈 문자열도 유지한다.
     * 각 구간 문자열의 길이를 결과 배열에 저장한다.
     */
    public int[] solution(String myString) {
        String[] parts = myString.split("x", -1);
        int[] answer = new int[parts.length];

        for (int i = 0; i < parts.length; i++) answer[i] = parts[i].length();
        return answer;
    }
}
