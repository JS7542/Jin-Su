import java.io.*; import java.util.*;
class Main {
    /*
     * 곱의 합을 최소화하려면 한 배열의 작은 값과 다른 배열의 큰 값을 짝지어야 한다.
     * 두 배열을 정렬한 뒤 서로 반대 방향 인덱스를 곱해 합산한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));int n=Integer.parseInt(br.readLine());int[]a=new int[n],b=new int[n];StringTokenizer st=new StringTokenizer(br.readLine());for(int i=0;i<n;i++)a[i]=Integer.parseInt(st.nextToken());st=new StringTokenizer(br.readLine());for(int i=0;i<n;i++)b[i]=Integer.parseInt(st.nextToken());Arrays.sort(a);Arrays.sort(b);int answer=0;for(int i=0;i<n;i++)answer+=a[i]*b[n-1-i];System.out.print(answer);
    }
}
