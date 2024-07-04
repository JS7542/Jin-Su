import java.io.*; import java.util.*;
class Main {
    /*
     * 로프를 오름차순 정렬하고 i번째 로프를 최소 강도로 사용할 때 가능한 중량을 계산한다.
     * 강도×사용 로프 수 중 최댓값을 선택한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));int n=Integer.parseInt(br.readLine());int[]a=new int[n];for(int i=0;i<n;i++)a[i]=Integer.parseInt(br.readLine());Arrays.sort(a);int answer=0;for(int i=0;i<n;i++)answer=Math.max(answer,a[i]*(n-i));System.out.print(answer);
    }
}
