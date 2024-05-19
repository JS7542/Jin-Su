import java.io.*;
class Main {
    /*
     * 첫 줄부터 공백은 증가하고 별은 두 개씩 감소한다.
     * N단 역피라미드를 각 줄의 공백과 별 개수 공식으로 출력한다.
     */
    public static void main(String[] args) throws Exception {
        int n=Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++) sb.append(" ".repeat(i)).append("*".repeat(2*(n-i)-1)).append('\n');
        System.out.print(sb);
    }
}
