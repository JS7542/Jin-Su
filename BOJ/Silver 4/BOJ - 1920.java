import java.io.*; import java.util.*;
class Main {
    /*
     * N개의 수를 정렬한 뒤 각 질의 값을 이분 탐색한다.
     * 존재하면 1, 존재하지 않으면 0을 한 줄씩 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));int n=Integer.parseInt(br.readLine());int[]a=new int[n];StringTokenizer st=new StringTokenizer(br.readLine());for(int i=0;i<n;i++)a[i]=Integer.parseInt(st.nextToken());Arrays.sort(a);int m=Integer.parseInt(br.readLine());st=new StringTokenizer(br.readLine());StringBuilder sb=new StringBuilder();while(m-->0)sb.append(Arrays.binarySearch(a,Integer.parseInt(st.nextToken()))>=0?1:0).append('\n');System.out.print(sb);
    }
}
