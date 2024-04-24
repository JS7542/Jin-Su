import java.io.*;

class Main {
    /*
     * 세 반복문이 모두 N번씩 수행되므로 실행 횟수는 N³이다.
     * long으로 세제곱을 계산하고 최고차항 차수 3을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        System.out.println(n * n * n);
        System.out.print(3);
    }
}
