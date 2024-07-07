import java.io.*;

class Main {
    /*
     * 서로 다른 세 인덱스를 고르는 경우의 수는 조합 C(N,3)이다.
     * N(N-1)(N-2)/6을 계산하고 최고차항 차수 3을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        System.out.println(n * (n - 1) * (n - 2) / 6);
        System.out.print(3);
    }
}
