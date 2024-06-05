import java.io.*;
class Main {
    /*
     * n을 만드는 방법 수는 마지막에 1, 2, 3을 붙이는 세 경우의 합이다.
     * 최대 입력 10까지 DP 배열을 미리 계산해 각 테스트 케이스에 답한다.
     */
    public static void main(String[] args) throws Exception {
        int[]dp=new int[11];dp[0]=1;for(int i=1;i<=10;i++)for(int k=1;k<=3;k++)if(i>=k)dp[i]+=dp[i-k];BufferedReader br=new BufferedReader(new InputStreamReader(System.in));int t=Integer.parseInt(br.readLine());StringBuilder sb=new StringBuilder();while(t-->0)sb.append(dp[Integer.parseInt(br.readLine())]).append('\n');System.out.print(sb);
    }
}
