import java.io.*;
class Main {
    /*
     * fib(n) 호출에서 0과 1이 출력되는 횟수도 피보나치 점화식을 따른다.
     * 두 횟수 배열을 40까지 미리 계산해 각 입력에 출력한다.
     */
    public static void main(String[] args) throws Exception {
        int[]z=new int[41],o=new int[41];z[0]=1;o[1]=1;for(int i=2;i<=40;i++){z[i]=z[i-1]+z[i-2];o[i]=o[i-1]+o[i-2];}BufferedReader br=new BufferedReader(new InputStreamReader(System.in));int t=Integer.parseInt(br.readLine());StringBuilder sb=new StringBuilder();while(t-->0){int n=Integer.parseInt(br.readLine());sb.append(z[n]).append(' ').append(o[n]).append('\n');}System.out.print(sb);
    }
}
