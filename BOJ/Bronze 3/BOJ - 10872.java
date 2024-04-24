import java.io.*;
class Main {
    /*
     * 1부터 N까지의 정수를 차례로 곱해 N!을 계산한다.
     * N이 0이면 반복문이 실행되지 않아 초기값 1이 그대로 반환된다.
     */
    public static void main(String[] args) throws Exception {
        int n=Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int answer=1;
        for(int i=2;i<=n;i++) answer*=i;
        System.out.print(answer);
    }
}
