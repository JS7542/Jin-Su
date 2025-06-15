class Solution {
    /*
     * 열 이름을 26진수처럼 왼쪽부터 누적한다.
     * A를 1, Z를 26으로 변환해 이전 값에 26을 곱한 뒤 더한다.
     */
    public int titleToNumber(String columnTitle) {
        int answer = 0;

        for (char ch : columnTitle.toCharArray()) {
            answer = answer * 26 + ch - 'A' + 1;
        }

        return answer;
    }
}
