import java.io.*; import java.util.*;
class Main {
    /*
     * 동전 가치가 배수 관계이므로 큰 동전부터 최대한 사용하는 그리디가 최적이다.
     * 각 동전의 사용 개수를 몫으로 더하고 남은 금액을 다음 동전에 넘긴다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));StringTokenizer st=new StringTokenizer(br.readLine());int n=Integer.parseInt(st.nextToken()),k=Integer.parseInt(st.nextToken());int[]coin=new int[n];for(int i=0;i<n;i++)coin[i]=Integer.parseInt(br.readLine());int answer=0;for(int i=n-1;i>=0;i--){answer+=k/coin[i];k%=coin[i];}System.out.print(answer);
    }
}
