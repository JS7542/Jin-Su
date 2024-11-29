class Solution {
    /*
     * k개 완전 행에 필요한 동전 수 k(k+1)/2가 n 이하인지 이분 탐색한다.
     * 조건을 만족하는 가장 큰 k를 반환한다.
     */
    public int arrangeCoins(int n){long l=0,r=n,ans=0;while(l<=r){long m=(l+r)/2,need=m*(m+1)/2;if(need<=n){ans=m;l=m+1;}else r=m-1;}return(int)ans;}
}
