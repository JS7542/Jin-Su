import java.io.*;
class Main {
    /*
     * 앞의 두 피보나치 값을 변수에 유지하며 다음 값을 반복 계산한다.
     * N번 이동한 뒤 현재 첫 번째 변수에 저장된 F(N)을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        int n=Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int a=0,b=1;
        for(int i=0;i<n;i++){ int next=a+b; a=b; b=next; }
        System.out.print(a);
    }
}
