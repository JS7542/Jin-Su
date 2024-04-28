import java.io.*;
class Main {
    /*
     * 각 수에서 가능한 이전 상태인 i-1, i/2, i/3의 최소 연산 횟수를 비교한다.
     * 1부터 N까지 DP를 채워 N을 1로 만드는 최소 횟수를 구한다.
     */
    public static void main(String[] args) throws Exception {
        int n=Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());int[]dp=new int[n+1];
        for(int i=2;i<=n;i++){dp[i]=dp[i-1]+1;if(i%2==0)dp[i]=Math.min(dp[i],dp[i/2]+1);if(i%3==0)dp[i]=Math.min(dp[i],dp[i/3]+1);}System.out.print(dp[n]);
    }
}
