import java.io.*;
class Main {
    /*
     * 각 줄은 앞 공백 뒤에 별을 한 칸 간격으로 i개 배치한다.
     * 마지막 별 뒤의 불필요한 공백 없이 피라미드 모양을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        int n=Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=n;i++){
            sb.append(" ".repeat(n-i));
            for(int j=0;j<i;j++){ if(j>0) sb.append(' '); sb.append('*'); }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
