import java.io.*;
class Main {
    /*
     * N이 최대 90이므로 피보나치 수를 long 자료형으로 계산한다.
     * 이전 두 항만 유지해 O(N) 시간과 O(1) 공간으로 해결한다.
     */
    public static void main(String[] args) throws Exception {
        int n=Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        long a=0,b=1;
        for(int i=0;i<n;i++){ long t=a+b; a=b; b=t; }
        System.out.print(a);
    }
}
