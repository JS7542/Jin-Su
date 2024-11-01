class Solution {
    /*
     * 모든 연산에 포함되는 좌상단 공통 영역이 최댓값을 가진다.
     * 각 연산의 a와 b 최솟값을 곱해 최대 원소의 개수를 계산한다.
     */
    public int maxCount(int m,int n,int[][] ops){int r=m,c=n;for(int[]op:ops){r=Math.min(r,op[0]);c=Math.min(c,op[1]);}return r*c;}
}
