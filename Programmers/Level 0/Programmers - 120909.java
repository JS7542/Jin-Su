class Solution {
    /*
     * n의 제곱근을 정수로 내린 값을 구한다.
     * 그 값을 다시 제곱했을 때 n과 같으면 제곱수다.
     */
    public int solution(int n){int r=(int)Math.sqrt(n);return r*r==n?1:2;}
}
