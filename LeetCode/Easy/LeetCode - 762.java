class Solution {
    /*
     * 범위의 각 수에 대해 이진수 1비트 개수를 계산한다.
     * 비트 개수가 소수이면 정답을 증가시킨다.
     */
    public int countPrimeSetBits(int left,int right){int ans=0;for(int n=left;n<=right;n++)if(prime(Integer.bitCount(n)))ans++;return ans;}private boolean prime(int n){if(n<2)return false;for(int i=2;i*i<=n;i++)if(n%i==0)return false;return true;}
}
