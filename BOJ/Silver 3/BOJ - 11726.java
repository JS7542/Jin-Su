import java.io.*;
class Main {
    /*
     * 마지막 칸을 세로 타일 하나 또는 가로 타일 두 개로 채우는 경우를 더한다.
     * dp[n]=dp[n-1]+dp[n-2]를 10007로 나누며 계산한다.
     */
    public static void main(String[] args) throws Exception {
        int n=Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());int[]dp=new int[Math.max(3,n+1)];dp[1]=1;dp[2]=2;for(int i=3;i<=n;i++)dp[i]=(dp[i-1]+dp[i-2])%10007;System.out.print(dp[n]);
    }
}
