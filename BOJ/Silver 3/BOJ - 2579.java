import java.io.*;
class Main {
    /*
     * i번째 계단은 i-2에서 오거나 i-3과 i-1을 연속해서 밟는 두 경우가 있다.
     * 두 경우 중 큰 점수에 현재 계단 점수를 더해 DP를 계산한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));int n=Integer.parseInt(br.readLine());int[]s=new int[n+1],dp=new int[n+1];for(int i=1;i<=n;i++)s[i]=Integer.parseInt(br.readLine());if(n>=1)dp[1]=s[1];if(n>=2)dp[2]=s[1]+s[2];for(int i=3;i<=n;i++)dp[i]=Math.max(dp[i-2],dp[i-3]+s[i-1])+s[i];System.out.print(dp[n]);
    }
}
