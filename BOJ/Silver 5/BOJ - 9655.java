import java.io.*;

class Main {
    /*
     * 한 번에 1개 또는 3개를 가져가므로 두 선택 모두 홀수 개를 줄인다.
     * 전체 돌 개수가 홀수면 선공, 짝수면 후공이 승리한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.print(n % 2 == 1 ? "SK" : "CY");
    }
}
