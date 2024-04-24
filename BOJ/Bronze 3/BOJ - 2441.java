import java.io.*;
class Main {
    /*
     * 줄이 내려갈수록 앞의 공백은 증가하고 별의 개수는 감소한다.
     * 공백과 별을 repeat로 조합해 오른쪽 정렬된 모양을 만든다.
     */
    public static void main(String[] args) throws Exception {
        int n=Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++) sb.append(" ".repeat(i)).append("*".repeat(n-i)).append('\n');
        System.out.print(sb);
    }
}
