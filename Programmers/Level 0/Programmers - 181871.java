class Solution {
    /*
     * myString에서 pat과 같은 길이의 모든 시작 위치를 확인한다.
     * 부분문자열이 pat과 같으면 등장 횟수를 증가시킨다.
     */
    public int solution(String myString, String pat) {
        int answer = 0;

        for (int start = 0; start <= myString.length() - pat.length(); start++) {
            if (myString.startsWith(pat, start)) answer++;
        }

        return answer;
    }
}
