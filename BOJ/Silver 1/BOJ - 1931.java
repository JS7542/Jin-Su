import java.io.*; import java.util.*;
class Main {
    /*
     * 회의를 종료 시간이 빠른 순서, 같으면 시작 시간이 빠른 순서로 정렬한다.
     * 마지막 종료 이후 시작 가능한 회의를 차례로 선택하면 최대 개수를 얻는다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));int n=Integer.parseInt(br.readLine());int[][]a=new int[n][2];for(int i=0;i<n;i++){StringTokenizer st=new StringTokenizer(br.readLine());a[i][0]=Integer.parseInt(st.nextToken());a[i][1]=Integer.parseInt(st.nextToken());}Arrays.sort(a,(x,y)->x[1]!=y[1]?Integer.compare(x[1],y[1]):Integer.compare(x[0],y[0]));int end=0,count=0;for(int[]v:a)if(v[0]>=end){end=v[1];count++;}System.out.print(count);
    }
}
