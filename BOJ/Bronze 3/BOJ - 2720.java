import java.io.*;
class Main {
    /*
     * 큰 동전 단위 25, 10, 5, 1센트 순서로 가능한 개수를 구한다.
     * 사용 후 남은 금액을 다음 단위로 넘겨 각 테스트 케이스를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));int t=Integer.parseInt(br.readLine());int[] coin={25,10,5,1};StringBuilder sb=new StringBuilder();
        while(t-->0){int c=Integer.parseInt(br.readLine());for(int v:coin){sb.append(c/v).append(' ');c%=v;}sb.append('\n');}
        System.out.print(sb);
    }
}
