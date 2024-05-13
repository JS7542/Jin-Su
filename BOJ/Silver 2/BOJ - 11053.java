import java.io.*; import java.util.*;
class Main {
    /*
     * dp[i]를 i번째 수로 끝나는 증가 부분 수열의 최대 길이로 정의한다.
     * 앞의 더 작은 수들을 확인해 최대 dp값에 1을 더한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));int n=Integer.parseInt(br.readLine());int[]a=new int[n],dp=new int[n];StringTokenizer st=new StringTokenizer(br.readLine());int answer=0;
        for(int i=0;i<n;i++)a[i]=Integer.parseInt(st.nextToken());for(int i=0;i<n;i++){dp[i]=1;for(int j=0;j<i;j++)if(a[j]<a[i])dp[i]=Math.max(dp[i],dp[j]+1);answer=Math.max(answer,dp[i]);}System.out.print(answer);
    }
}
