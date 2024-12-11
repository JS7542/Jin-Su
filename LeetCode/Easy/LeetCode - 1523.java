class Solution {
    /*
     * 0부터 x까지의 홀수 개수는 (x+1)/2로 계산할 수 있다.
     * high까지의 개수에서 low 이전까지의 개수를 빼 구간 답을 구한다.
     */
    public int countOdds(int low, int high) {
        return (high + 1) / 2 - low / 2;
    }
}
