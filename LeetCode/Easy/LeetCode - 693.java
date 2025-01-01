class Solution {
    /*
     * 인접한 비트가 모두 다르면 n XOR (n>>1)은 유효 범위에서 모두 1이 된다.
     * x와 x+1의 AND가 0인지 확인해 연속 1비트 형태를 판별한다.
     */
    public boolean hasAlternatingBits(int n){int x=n^(n>>1);return (x&(x+1))==0;}
}
