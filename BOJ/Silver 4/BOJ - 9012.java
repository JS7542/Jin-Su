import java.io.*;
class Main {
    /*
     * 여는 괄호는 균형값을 증가시키고 닫는 괄호는 감소시킨다.
     * 중간에 음수가 되지 않고 마지막 균형이 0이면 올바른 괄호 문자열이다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));int t=Integer.parseInt(br.readLine());StringBuilder sb=new StringBuilder();while(t-->0){int balance=0;boolean ok=true;for(char c:br.readLine().toCharArray()){balance+=c=='('?1:-1;if(balance<0)ok=false;}sb.append(ok&&balance==0?"YES":"NO").append('\n');}System.out.print(sb);
    }
}
