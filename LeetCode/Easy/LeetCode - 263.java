class Solution {
    /*
     * 양수 n에서 소인수 2, 3, 5를 가능한 만큼 반복해서 제거한다.
     * 최종 값이 1이면 다른 소인수가 없는 ugly number다.
     */
    public boolean isUgly(int n){if(n<=0)return false;for(int p:new int[]{2,3,5})while(n%p==0)n/=p;return n==1;}
}
