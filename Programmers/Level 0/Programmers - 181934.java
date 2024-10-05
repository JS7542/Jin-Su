class Solution {
    /*
     * ineq와 eq를 이어 실제 비교 연산자의 종류를 결정한다.
     * n과 m의 비교 결과가 조건을 만족하면 1, 아니면 0을 반환한다.
     */
    public int solution(String ineq, String eq, int n, int m) {
        if (ineq.equals(">")) {
            return eq.equals("=") ? (n >= m ? 1 : 0) : (n > m ? 1 : 0);
        }

        return eq.equals("=") ? (n <= m ? 1 : 0) : (n < m ? 1 : 0);
    }
}
