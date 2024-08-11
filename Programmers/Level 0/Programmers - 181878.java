class Solution {
    /*
     * 두 문자열을 모두 소문자로 바꾸어 대소문자 차이를 제거한다.
     * myString에 pat이 포함되면 1, 아니면 0을 반환한다.
     */
    public int solution(String myString, String pat) {
        return myString.toLowerCase().contains(pat.toLowerCase()) ? 1 : 0;
    }
}
