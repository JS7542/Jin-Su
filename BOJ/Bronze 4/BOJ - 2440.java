import java.io.*;
class Main {
    /*
     * 첫 줄에 N개의 별을 출력하고 줄마다 별의 개수를 하나씩 줄인다.
     * 전체 결과를 StringBuilder에 누적해 한 번에 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for(int i=n;i>=1;i--) sb.append("*".repeat(i)).append('\n');
        System.out.print(sb);
    }
}
