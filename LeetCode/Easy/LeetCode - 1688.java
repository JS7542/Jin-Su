class Solution {
    /*
     * 한 경기마다 정확히 한 팀이 탈락한다.
     * 우승팀 하나만 남으려면 전체 팀 수에서 1을 뺀 경기 수가 필요하다.
     */
    public int numberOfMatches(int n) {
        return n - 1;
    }
}
