class Solution {
    /*
     * 이전 두 피보나치 수를 변수로 유지한다.
     * n번 반복한 뒤 F(n)에 해당하는 값을 반환한다.
     */
    public int fib(int n){int a=0,b=1;for(int i=0;i<n;i++){int t=a+b;a=b;b=t;}return a;}
}
