import java.io.*;

class Main {
    /*
     * 두 반복문이 각각 N번 수행되므로 총 실행 횟수는 N²이다.
     * 큰 값을 위해 long으로 계산하고 최고차항 차수 2를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        System.out.println(n * n);
        System.out.print(2);
    }
}
