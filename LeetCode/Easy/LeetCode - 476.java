class Solution {
    /*
     * num의 최고 비트까지 모두 1인 마스크를 만든다.
     * num과 마스크를 XOR해 유효 비트 범위만 반전한다.
     */
    public int findComplement(int num){int mask=1;while(mask<=num)mask<<=1;return (mask-1)^num;}
}
