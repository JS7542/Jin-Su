class Solution {
    /*
     * 두 수를 XOR하면 서로 다른 비트 위치만 1이 된다.
     * Integer.bitCount로 1비트 개수를 계산한다.
     */
    public int hammingDistance(int x,int y){return Integer.bitCount(x^y);}
}
