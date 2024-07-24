import java.io.*; import java.util.*;
class Main {
    /*
     * 각 위치까지의 최대 합은 바로 위와 왼쪽 위 경로 중 큰 값에 현재 값을 더한 것이다.
     * 삼각형을 행별로 읽으며 DP를 갱신하고 마지막 행의 최댓값을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));int n=Integer.parseInt(br.readLine());int[][]dp=new int[n][n];
        for(int i=0;i<n;i++){StringTokenizer st=new StringTokenizer(br.readLine());for(int j=0;j<=i;j++){int v=Integer.parseInt(st.nextToken());int left=j>0?dp[i-1][j-1]:0;int right=j<i?dp[i-1][j]:0;dp[i][j]=v+(i==0?0:Math.max(left,right));}}
        int answer=0;for(int v:dp[n-1])answer=Math.max(answer,v);System.out.print(answer);
    }
}
