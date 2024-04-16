import java.io.*;

class Main {
    /*
     * i보다 큰 j를 선택하는 모든 쌍의 수는 N(N-1)/2이다.
     * 수행 횟수를 long으로 계산하고 최고차항 차수 2를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        System.out.println(n * (n - 1) / 2);
        System.out.print(2);
    }
}
