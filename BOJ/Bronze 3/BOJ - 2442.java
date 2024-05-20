import java.io.*;
class Main {
    /*
     * i번째 줄은 앞에 N-i개의 공백과 2i-1개의 별을 가진다.
     * 위에서 아래로 별이 두 개씩 늘어나는 피라미드를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        int n=Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=n;i++) sb.append(" ".repeat(n-i)).append("*".repeat(2*i-1)).append('\n');
        System.out.print(sb);
    }
}
