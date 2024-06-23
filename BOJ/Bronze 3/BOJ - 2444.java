import java.io.*;
class Main {
    /*
     * 위쪽 피라미드와 가운데를 제외한 아래쪽 역피라미드를 연이어 만든다.
     * 각 줄의 공백과 별 개수를 대칭적으로 계산한다.
     */
    public static void main(String[] args) throws Exception {
        int n=Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=n;i++) sb.append(" ".repeat(n-i)).append("*".repeat(2*i-1)).append('\n');
        for(int i=n-1;i>=1;i--) sb.append(" ".repeat(n-i)).append("*".repeat(2*i-1)).append('\n');
        System.out.print(sb);
    }
}
