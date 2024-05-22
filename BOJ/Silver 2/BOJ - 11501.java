import java.io.*; import java.util.*;
class Main {
    /*
     * 뒤에서부터 현재 이후의 최고 가격을 유지한다.
     * 오늘 가격이 최고 가격보다 낮으면 그 차이를 이익에 더하고 높으면 최고값을 갱신한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));int t=Integer.parseInt(br.readLine());StringBuilder out=new StringBuilder();while(t-->0){int n=Integer.parseInt(br.readLine());long[]a=new long[n];StringTokenizer st=new StringTokenizer(br.readLine());for(int i=0;i<n;i++)a[i]=Long.parseLong(st.nextToken());long max=0,profit=0;for(int i=n-1;i>=0;i--){if(a[i]>max)max=a[i];else profit+=max-a[i];}out.append(profit).append('\n');}System.out.print(out);
    }
}
