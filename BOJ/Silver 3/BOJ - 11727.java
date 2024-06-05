import java.io.*;
class Main {
    /*
     * 마지막 두 열을 채우는 방법은 가로 타일 두 개와 2×2 타일로 두 가지다.
     * dp[n]=dp[n-1]+2×dp[n-2] 점화식을 10007로 나누어 계산한다.
     */
    public static void main(String[] args) throws Exception {
        int n=Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());int[]dp=new int[Math.max(3,n+1)];dp[1]=1;dp[2]=3;for(int i=3;i<=n;i++)dp[i]=(dp[i-1]+2*dp[i-2])%10007;System.out.print(dp[n]);
    }
}
