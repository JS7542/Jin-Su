import java.io.*;
class Main {
    /*
     * 파도반 수열은 P(n)=P(n-2)+P(n-3) 점화식을 따른다.
     * 최대 100까지 long 배열을 미리 계산해 테스트 케이스에 답한다.
     */
    public static void main(String[] args) throws Exception {
        long[]p=new long[101];p[1]=p[2]=p[3]=1;for(int i=4;i<=100;i++)p[i]=p[i-2]+p[i-3];BufferedReader br=new BufferedReader(new InputStreamReader(System.in));int t=Integer.parseInt(br.readLine());StringBuilder sb=new StringBuilder();while(t-->0)sb.append(p[Integer.parseInt(br.readLine())]).append('\n');System.out.print(sb);
    }
}
