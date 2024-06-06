import java.io.*;
class Main {
    /*
     * 첫 줄은 별 하나, 마지막 줄은 별로 가득 채우고 중간은 양 끝만 별을 찍는다.
     * 줄 번호에 따라 내부 공백 수를 계산해 속이 빈 피라미드를 만든다.
     */
    public static void main(String[] args) throws Exception {
        int n=Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=n;i++){
            sb.append(" ".repeat(n-i));
            if(i==1) sb.append('*');
            else if(i==n) sb.append("*".repeat(2*n-1));
            else sb.append('*').append(" ".repeat(2*i-3)).append('*');
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
