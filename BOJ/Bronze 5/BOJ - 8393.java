import java.io.*;

class Main {
    /*
     * 1부터 N까지의 정수 합을 등차수열 공식으로 계산한다.
     * 반복문 없이 N*(N+1)/2를 사용해 결과를 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        System.out.print(n * (n + 1) / 2);
    }
}
