class Solution {
    /*
     * n이 3으로 나누어떨어지는 동안 반복해서 3으로 나눈다.
     * 최종 값이 1이면 3의 거듭제곱이다.
     */
    public boolean isPowerOfThree(int n){if(n<1)return false;while(n%3==0)n/=3;return n==1;}
}
