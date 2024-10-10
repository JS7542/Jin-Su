class Solution {
    /*
     * 2의 거듭제곱은 이진수에서 1비트가 하나만 존재한다.
     * n이 양수이며 n과 n-1의 AND 결과가 0인지 확인한다.
     */
    public boolean isPowerOfTwo(int n){return n>0&&(n&(n-1))==0;}
}
