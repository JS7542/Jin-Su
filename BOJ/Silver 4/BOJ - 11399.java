import java.io.*; import java.util.*;
class Main {
    /*
     * 인출 시간이 짧은 사람부터 처리해야 뒤 사람들의 대기시간 합이 최소가 된다.
     * 정렬 후 누적 시간과 그 누적값의 합을 계산한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));int n=Integer.parseInt(br.readLine());int[]a=new int[n];StringTokenizer st=new StringTokenizer(br.readLine());for(int i=0;i<n;i++)a[i]=Integer.parseInt(st.nextToken());Arrays.sort(a);int prefix=0,answer=0;for(int x:a){prefix+=x;answer+=prefix;}System.out.print(answer);
    }
}
