import java.io.*; import java.util.*;
class Main {
    /*
     * N×M개의 조각을 하나씩 분리하려면 전체 조각 수보다 한 번 적게 잘라야 한다.
     * 따라서 최소 횟수는 N×M-1이다.
     */
    public static void main(String[] args) throws Exception {
        StringTokenizer st=new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int n=Integer.parseInt(st.nextToken()),m=Integer.parseInt(st.nextToken());
        System.out.print(n*m-1);
    }
}
