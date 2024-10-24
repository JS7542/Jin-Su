class Solution {
    /*
     * 길이 3인 각 구간에서 세 문자가 모두 같은지 확인한다.
     * 조건을 만족하는 숫자 중 가장 큰 문자를 세 번 이어 반환한다.
     */
    public String largestGoodInteger(String num) {
        char best = 0;

        for (int i = 0; i + 2 < num.length(); i++) {
            char ch = num.charAt(i);

            if (ch == num.charAt(i + 1) && ch == num.charAt(i + 2)) {
                best = (char) Math.max(best, ch);
            }
        }

        return best == 0 ? "" : String.valueOf(best).repeat(3);
    }
}
