class Solution {
    /*
     * 문자열 배열과 같은 길이의 정수 배열을 생성한다.
     * 각 위치에 해당 문자열의 길이를 저장해 반환한다.
     */
    public int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length];
        for (int i = 0; i < strlist.length; i++) answer[i] = strlist[i].length();
        return answer;
    }
}
