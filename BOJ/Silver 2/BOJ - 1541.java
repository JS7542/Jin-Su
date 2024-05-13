import java.io.*;
class Main {
    /*
     * 첫 번째 마이너스 이후의 모든 수를 빼도록 괄호를 묶으면 결과가 최소가 된다.
     * 식을 -로 나누고 각 구간의 덧셈 결과를 첫 구간에서는 더하고 이후에는 뺀다.
     */
    public static void main(String[] args) throws Exception {
        String[]groups=new BufferedReader(new InputStreamReader(System.in)).readLine().split("-");int answer=sum(groups[0]);for(int i=1;i<groups.length;i++)answer-=sum(groups[i]);System.out.print(answer);
    }
    static int sum(String s){int r=0;for(String x:s.split("\\+"))r+=Integer.parseInt(x);return r;}
}
