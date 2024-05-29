class Solution {
    /*
     * 문자열 길이별 등장 횟수를 배열에 저장한다.
     * 같은 길이를 가진 문자열 그룹 중 가장 큰 크기를 반환한다.
     */
    public int solution(String[] strArr) {
        int[] count = new int[31];
        int answer = 0;

        for (String text : strArr) {
            answer = Math.max(answer, ++count[text.length()]);
        }

        return answer;
    }
}
