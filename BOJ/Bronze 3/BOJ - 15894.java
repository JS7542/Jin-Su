import java.io.*;

class Main {
    /*
     * 계단 모양 도형의 바깥 둘레는 각 단계마다 4만큼 증가한다.
     * 입력 범위를 고려해 long으로 N×4를 계산한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        System.out.print(n * 4);
    }
}
