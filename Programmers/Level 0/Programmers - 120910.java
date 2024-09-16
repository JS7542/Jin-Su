class Solution {
    /*
     * 세균은 한 시간마다 두 배가 되므로 t시간 뒤에는 2의 t제곱만큼 증가한다.
     * n에 1을 t비트 왼쪽 이동한 값을 곱해 반환한다.
     */
    public int solution(int n,int t){return n*(1<<t);}
}
