class Solution {
    /*
     * code의 인덱스를 q로 나눈 나머지가 r인 위치만 선택한다.
     * 선택된 문자를 순서대로 이어 붙여 반환한다.
     */
    public String solution(int q, int r, String code) {
        StringBuilder answer = new StringBuilder();

        for (int i = r; i < code.length(); i += q) answer.append(code.charAt(i));
        return answer.toString();
    }
}
