import java.io.*; import java.util.*;
class Main {
    /*
     * 왼쪽부터 이동하며 지금까지 만난 가장 싼 주유 가격을 유지한다.
     * 각 도로 거리에 최소 가격을 곱해 전체 비용을 누적한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));int n=Integer.parseInt(br.readLine());long[]d=new long[n-1];StringTokenizer st=new StringTokenizer(br.readLine());for(int i=0;i<n-1;i++)d[i]=Long.parseLong(st.nextToken());st=new StringTokenizer(br.readLine());long min=Long.MAX_VALUE,answer=0;for(int i=0;i<n;i++){long price=Long.parseLong(st.nextToken());if(i<n-1){min=Math.min(min,price);answer+=min*d[i];}}System.out.print(answer);
    }
}
