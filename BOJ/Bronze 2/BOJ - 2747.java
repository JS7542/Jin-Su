import java.io.*;
class Main {
    /*
     * F(0)=0, F(1)=1에서 시작해 두 이전 값을 이용해 다음 항을 만든다.
     * 배열 없이 두 변수만 사용하여 N번째 피보나치 수를 계산한다.
     */
    public static void main(String[] args) throws Exception {
        int n=Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int a=0,b=1;
        for(int i=0;i<n;i++){ int t=a+b; a=b; b=t; }
        System.out.print(a);
    }
}
